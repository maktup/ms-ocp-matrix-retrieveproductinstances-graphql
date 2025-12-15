package org.acme.graphql.types;

import org.eclipse.microprofile.graphql.Description;
import org.eclipse.microprofile.graphql.Type;

/**
 * Ubicación asociada al producto (dirección de instalación, entrega, etc.).
 */
@Type("Place")
public class Place {

    private String id;
    private String name;
    private String href;
    private String description;
    private String role;
    private String entityType;
    private String referredType;
    private Coordinates coordinates;
    private LocaleRef department;
    private LocaleRef province;
    private LocaleRef district;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEntityType() {
        return entityType;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    public String getReferredType() {
        return referredType;
    }

    public void setReferredType(String referredType) {
        this.referredType = referredType;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    @Description("Departamento")
    public LocaleRef getDepartment() {
        return department;
    }

    public void setDepartment(LocaleRef department) {
        this.department = department;
    }

    @Description("Provincia")
    public LocaleRef getProvince() {
        return province;
    }

    public void setProvince(LocaleRef province) {
        this.province = province;
    }

    @Description("Distrito")
    public LocaleRef getDistrict() {
        return district;
    }

    public void setDistrict(LocaleRef district) {
        this.district = district;
    }
}
