package com.finflow.settlement_service.dto.response;

import java.math.BigDecimal;
import java.util.UUID;

public class TransactionResponse {

    private UUID id;
    private BigDecimal amount;
    private String currency;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

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