package org.acme;

import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import org.acme.graphql.mapper.ProductMapper;
import org.acme.graphql.types.Product;
import org.eclipse.microprofile.graphql.Description;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Name;
import org.eclipse.microprofile.graphql.Query;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;
import java.util.stream.Collectors;

@GraphQLApi
public class ProductGraphResource {

    @Inject
    @RestClient
    ProductInventoryService productInventoryService;

    @Query("products")
    @Description("Recupera la lista de productos en inventario")
    public Uni<List<Product>> getProducts(
            @Name("type") String type,
            @Name("publicId") String publicId,
            @Name("nationalId") String nationalId,
            @Name("nationalIdType") String nationalIdType
    ) {
        return productInventoryService
                .getProducts(type, publicId, nationalId, nationalIdType)
                .map(list -> list == null
                        ? List.of()
                        : list.stream()
                        .map(ProductMapper::toGraphQL)
                        .collect(Collectors.toList()));
    }
}
