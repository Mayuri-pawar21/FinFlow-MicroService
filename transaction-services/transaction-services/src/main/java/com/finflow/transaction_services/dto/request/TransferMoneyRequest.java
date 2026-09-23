package com.finflow.transaction_services.dto.request;

import java.math.BigDecimal;
import java.util.UUID;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

public class TransferMoneyRequest {

	 @NotNull
	    private UUID senderAccountId;

	    @NotNull
	    private UUID receiverAccountId;

	    @NotNull
	    @DecimalMin(value = "0.01")
	    private BigDecimal amount;

	    public TransferMoneyRequest() {
	    }

	    public UUID getSenderAccountId() {
	        return senderAccountId;
	    }

	    public void setSenderAccountId(UUID senderAccountId) {
	        this.senderAccountId = senderAccountId;
	    }

	    public UUID getReceiverAccountId() {
	        return receiverAccountId;
	    }

	    public void setReceiverAccountId(UUID receiverAccountId) {
	        this.receiverAccountId = receiverAccountId;
	    }

	    public BigDecimal getAmount() {
	        return amount;
	    }

	    public void setAmount(BigDecimal amount) {
	        this.amount = amount;
	    }
}
