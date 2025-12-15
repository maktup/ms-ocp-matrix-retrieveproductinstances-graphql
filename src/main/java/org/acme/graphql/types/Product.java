package org.acme.graphql.types;

import org.eclipse.microprofile.graphql.Description;
import org.eclipse.microprofile.graphql.Type;

import java.util.ArrayList;
import java.util.List;

/**
 * DTO GraphQL para productos del inventario.
 */
@Type("Product")
public class Product {

    private String id;
    private String publicId;
    private String name;
    private String description;
    private String productType;
    private String status;
    private String subStatus;
    private String href;
    private Boolean isBundle;
    private String startDate;
    private String terminationDate;
    private String orderDate;

    @Description("Características polimórficas del producto")
    private List<ProductCharacteristic> characteristic = new ArrayList<>();

    @Description("Cuentas de facturación asociadas")
    private List<BillingAccount> billingAccount = new ArrayList<>();

    @Description("Oferta de producto asociada")
    private EntityRef productOffering;

    @Description("Especificación del producto")
    private EntityRef productSpec;

    @Description("Ubicaciones asociadas al producto")
    private List<Place> place = new ArrayList<>();

    @Description("Partes relacionadas (cliente, usuario, etc.)")
    private List<RelatedParty> relatedParty = new ArrayList<>();

    @Description("Precios del producto")
    private List<ProductPrice> productPrice = new ArrayList<>();

    @Description("Relaciones con otros productos (subproductos, bundles, etc.)")
    private List<ProductRelationship> productRelationship = new ArrayList<>();

    @Description("Etiquetas del producto")
    private List<String> tags = new ArrayList<>();

    // Getters and Setters

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

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSubStatus() {
        return subStatus;
    }

    public void setSubStatus(String subStatus) {
        this.subStatus = subStatus;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public Boolean getIsBundle() {
        return isBundle;
    }

    public void setIsBundle(Boolean isBundle) {
        this.isBundle = isBundle;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getTerminationDate() {
        return terminationDate;
    }

    public void setTerminationDate(String terminationDate) {
        this.terminationDate = terminationDate;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public List<ProductCharacteristic> getCharacteristic() {
        return characteristic;
    }

    public void setCharacteristic(List<ProductCharacteristic> characteristic) {
        this.characteristic = characteristic != null ? characteristic : new ArrayList<>();
    }

    public List<BillingAccount> getBillingAccount() {
        return billingAccount;
    }

    public void setBillingAccount(List<BillingAccount> billingAccount) {
        this.billingAccount = billingAccount != null ? billingAccount : new ArrayList<>();
    }

    public EntityRef getProductOffering() {
        return productOffering;
    }

    public void setProductOffering(EntityRef productOffering) {
        this.productOffering = productOffering;
    }

    public EntityRef getProductSpec() {
        return productSpec;
    }

    public void setProductSpec(EntityRef productSpec) {
        this.productSpec = productSpec;
    }

    public List<Place> getPlace() {
        return place;
    }

    public void setPlace(List<Place> place) {
        this.place = place != null ? place : new ArrayList<>();
    }

    public List<RelatedParty> getRelatedParty() {
        return relatedParty;
    }

    public void setRelatedParty(List<RelatedParty> relatedParty) {
        this.relatedParty = relatedParty != null ? relatedParty : new ArrayList<>();
    }

    public List<ProductPrice> getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(List<ProductPrice> productPrice) {
        this.productPrice = productPrice != null ? productPrice : new ArrayList<>();
    }

    public List<ProductRelationship> getProductRelationship() {
        return productRelationship;
    }

    public void setProductRelationship(List<ProductRelationship> productRelationship) {
        this.productRelationship = productRelationship != null ? productRelationship : new ArrayList<>();
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags != null ? tags : new ArrayList<>();
    }
}
