package org.acme.graphql.types;

import org.eclipse.microprofile.graphql.Type;

import java.math.BigDecimal;

/**
 * Representa un monto monetario.
 */
@Type("Money")
public class Money {

    private BigDecimal amount;
    private String currency;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
