package org.acme.graphql.types;

import java.math.BigDecimal;
import java.util.List;

public class DataQuota {

    private BigDecimal dataAllowance;
    private String unit;
    private List<String> timeBands;
    private List<String> origins;
    private List<String> destinations;

    public BigDecimal getDataAllowance() {
        return dataAllowance;
    }

    public void setDataAllowance(BigDecimal dataAllowance) {
        this.dataAllowance = dataAllowance;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public List<String> getTimeBands() {
        return timeBands;
    }

    public void setTimeBands(List<String> timeBands) {
        this.timeBands = timeBands;
    }

    public List<String> getOrigins() {
        return origins;
    }

    public void setOrigins(List<String> origins) {
        this.origins = origins;
    }

    public List<String> getDestinations() {
        return destinations;
    }

    public void setDestinations(List<String> destinations) {
        this.destinations = destinations;
    }
}
