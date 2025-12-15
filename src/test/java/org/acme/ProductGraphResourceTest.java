package org.acme;

import com.itelcorp.product.dto.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.InputStream;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

@QuarkusTest
class ProductGraphResourceTest {

    @InjectMock
    @RestClient
    ProductInventoryService productInventoryService;

    @Test
    void products_query_should_return_polymorphic_characteristics() {
        // Arrange: mock REST client with full backend fixture
        List<ProductInstanceType> backend = loadBackendFixture();
        Mockito.when(productInventoryService.getProducts(
                        Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any()))
                .thenReturn(Uni.createFrom().item(backend));

        String query = """
                query {
                  products(type: "mobile", publicId: "951097003") {
                    publicId
                    name
                    productType
                    characteristic {
                      ... on StringType {
                        name
                        value
                      }
                      ... on MobileQuota {
                        code
                        quotaValue {
                          voiceQuota { voiceAllowance unit }
                          dataQuota  { dataAllowance unit }
                          smsQuota   { smsAllowance }
                        }
                      }
                    }
                  }
                }
                """;

        // Act & Assert
        RestAssured.given()
                .contentType(ContentType.JSON)
                .body(java.util.Map.of("query", query))
                .post("/graphql")
                .then()
                .statusCode(200)
                .body("data.products.size()", is(1))
                .body("data.products[0].publicId", equalTo("951097003"))
                .body("data.products[0].characteristic.find { it.name == 'MSISDN' }.value",
                        equalTo("951097003"))
                .body("data.products[0].characteristic.find { it.quotaValue != null }.quotaValue.voiceQuota[0].voiceAllowance",
                        equalTo(-1))
                .body("data.products[0].characteristic.find { it.quotaValue != null }.quotaValue.dataQuota[0].dataAllowance",
                        equalTo(6));
    }

    private List<ProductInstanceType> loadBackendFixture() {
        try (InputStream is = getClass().getResourceAsStream("/backend.json")) {
            ObjectMapper mapper = new ObjectMapper()
                    .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return mapper.readValue(is, new TypeReference<>() {});
        } catch (Exception e) {
            throw new RuntimeException("Cannot load backend.json fixture", e);
        }
    }
}
