package com.finflow.reconciliation_service.dto.request;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;

public class CreateReconciliationRequest {

    @NotNull
    private UUID transactionId;

    @NotNull
    private UUID settlementId;

    public UUID getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(UUID transactionId) {
        this.transactionId = transactionId;
    }

    public UUID getSettlementId() {
        return settlementId;
    }

    public void setSettlementId(UUID settlementId) {
        this.settlementId = settlementId;
    }
}