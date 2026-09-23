package com.finflow.transaction_services.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import com.finflow.transaction_services.enums.CurrencyType;
import com.finflow.transaction_services.enums.TransactionStatus;
import com.finflow.transaction_services.enums.TransactionType;

public class TransactionResponse {

	 private UUID id;
	    private String transactionReference;
	    private UUID senderAccountId;
	    private UUID receiverAccountId;
	    private BigDecimal amount;
	    private CurrencyType currency;
	    private TransactionStatus status;
	    private TransactionType type;
	    private LocalDateTime createdAt;

	    public TransactionResponse() {
	    }

	    public UUID getId() {
	        return id;
	    }

	    public void setId(UUID id) {
	        this.id = id;
	    }

	    public String getTransactionReference() {
	        return transactionReference;
	    }

	    public void setTransactionReference(String transactionReference) {
	        this.transactionReference = transactionReference;
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

	    public CurrencyType getCurrency() {
	        return currency;
	    }

	    public void setCurrency(CurrencyType currency) {
	        this.currency = currency;
	    }

	    public TransactionStatus getStatus() {
	        return status;
	    }

	    public void setStatus(TransactionStatus status) {
	        this.status = status;
	    }

	    public TransactionType getType() {
	        return type;
	    }

	    public void setType(TransactionType type) {
	        this.type = type;
	    }

	    public LocalDateTime getCreatedAt() {
	        return createdAt;
	    }

	    public void setCreatedAt(LocalDateTime createdAt) {
	        this.createdAt = createdAt;
	    }
}
