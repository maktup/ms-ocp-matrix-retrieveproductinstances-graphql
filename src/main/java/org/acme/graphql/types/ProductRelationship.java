package org.acme.graphql.types;

import org.eclipse.microprofile.graphql.Description;
import org.eclipse.microprofile.graphql.Type;

/**
 * Relación de producto (subproducto, bundled, dependent, etc.).
 */
@Type("ProductRelationship")
public class ProductRelationship {

    private String type;
    private RelatedProduct product;

    @Description("Tipo de relación: subproduct, bundled, dependent, etc.")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Description("Producto relacionado")
    public RelatedProduct getProduct() {
        return product;
    }

    public void setProduct(RelatedProduct product) {
        this.product = product;
    }
}
