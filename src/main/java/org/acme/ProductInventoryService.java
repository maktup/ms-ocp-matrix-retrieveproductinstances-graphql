package org.acme;

import com.itelcorp.product.dto.ProductInstanceType;
import io.smallrye.mutiny.Uni;
import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import java.time.temporal.ChronoUnit;
import java.util.List;

@RegisterRestClient(configKey = "product-inventory-service")
public interface ProductInventoryService {

    @GET
    @Path("/products")
    @Timeout(value = 13, unit = ChronoUnit.SECONDS)
    @CircuitBreaker(
            requestVolumeThreshold = 4,
            delay = 15000,
            delayUnit = ChronoUnit.MILLIS,
            successThreshold = 2
    )
    @Fallback(fallbackMethod = "fallbackProducts")
    Uni<List<ProductInstanceType>> getProducts(
        @QueryParam("type") String type,
        @QueryParam("publicId") String publicId,
        @QueryParam("nationalId") String nationalId,
        @QueryParam("nationalIdType") String nationalIdType
    );

    // Fallback simple: devuelve lista vacía ante fallo/circuito abierto
    default Uni<List<ProductInstanceType>> fallbackProducts(String type, String publicId, String nationalId, String nationalIdType) {
        return Uni.createFrom().item(List.of());
    }


}
