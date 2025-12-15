package org.acme.graphql.types;

import org.eclipse.microprofile.graphql.Description;
import org.eclipse.microprofile.graphql.Type;

import java.util.ArrayList;
import java.util.List;

/**
 * Producto relacionado (subproducto de un bundle, etc.).
 */
@Type("RelatedProduct")
public class RelatedProduct {

    private String id;
    private String publicId;
    private String name;
    private String description;
    private String productType;
    private String href;
    private List<ProductCharacteristic> characteristic = new ArrayList<>();
    private List<ProductRelationship> productRelationship = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPublicId() {
        return publicId;
    }

    public void setPublicId(String publicId) {
        this.publicId = publicId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Description("Tipo de producto: mobile, landline, broadband, bundle, etc.")
    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    @Description("Características del producto relacionado")
    public List<ProductCharacteristic> getCharacteristic() {
        return characteristic;
    }

    public void setCharacteristic(List<ProductCharacteristic> characteristic) {
        this.characteristic = characteristic != null ? characteristic : new ArrayList<>();
    }

    @Description("Relaciones anidadas de productos")
    public List<ProductRelationship> getProductRelationship() {
        return productRelationship;
    }

    public void setProductRelationship(List<ProductRelationship> productRelationship) {
        this.productRelationship = productRelationship != null ? productRelationship : new ArrayList<>();
    }
}
