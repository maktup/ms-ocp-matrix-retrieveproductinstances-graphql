package org.acme.graphql.types;

import org.eclipse.microprofile.graphql.Type;

@Type("MobileQuota")
public class MobileQuotaCharacteristic implements ProductCharacteristic {

    private String code;
    private MobileQuotaValue quotaValue;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public MobileQuotaValue getQuotaValue() {
        return quotaValue;
    }

    public void setQuotaValue(MobileQuotaValue quotaValue) {
        this.quotaValue = quotaValue;
    }
}
