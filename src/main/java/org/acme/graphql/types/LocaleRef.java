package org.acme.graphql.types;

import org.eclipse.microprofile.graphql.Type;

/**
 * Referencia a ubicación geográfica (departamento, provincia, distrito).
 */
@Type("LocaleRef")
public class LocaleRef {

    private String code;
    private String description;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
