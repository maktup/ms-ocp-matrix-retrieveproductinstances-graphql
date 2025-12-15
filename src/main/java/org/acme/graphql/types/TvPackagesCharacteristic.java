package org.acme.graphql.types;

import org.eclipse.microprofile.graphql.Type;

@Type("TvPackages")
public class TvPackagesCharacteristic implements ProductCharacteristic {

    private String code;
    /**
     * Valor serializado en JSON para evitar tipos dinámicos no tipados.
     */
    private String valueJson;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValueJson() {
        return valueJson;
    }

    public void setValueJson(String valueJson) {
        this.valueJson = valueJson;
    }
}
