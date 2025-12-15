package org.acme.graphql.types;

import org.eclipse.microprofile.graphql.Type;

@Type("Text")
public class TextCharacteristic implements ProductCharacteristic {

    private String code;
    private String name;
    private String value;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
