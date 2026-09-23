package com.finflow.reconciliation_service.client;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.finflow.reconciliation_service.config.FeignConfig;

@FeignClient(
        name = "TRANSACTION-SERVICE",
        configuration = FeignConfig.class
)
public interface TransactionClient {

    @GetMapping("/api/transactions/{id}")
    TransactionResponse getTransactionById(
            @PathVariable UUID id);


    class TransactionResponse {

        private UUID id;
        private String transactionReference;
        private UUID senderAccountId;
        private UUID receiverAccountId;
        private BigDecimal amount;
        private String currency;
        private String status;
        private String type;
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

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public LocalDateTime getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
        }
    }
}