package com.finflow.reconciliation_service.client;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.finflow.reconciliation_service.config.FeignConfig;

@FeignClient(
        name = "SETTLEMENT-SERVICE",
        configuration = FeignConfig.class
)
public interface SettlementClient {

    @GetMapping("/api/settlements/{id}")
    SettlementResponse getSettlementById(
            @PathVariable UUID id);


    class SettlementResponse {

        private UUID id;
        private UUID transactionId;
        private BigDecimal amount;
        private String currency;
        private String status;
        private LocalDateTime createdAt;
        private LocalDateTime settledAt;

        public SettlementResponse() {
        }

        public UUID getId() {
            return id;
        }

        public void setId(UUID id) {
            this.id = id;
        }

        public UUID getTransactionId() {
            return transactionId;
        }

        public void setTransactionId(UUID transactionId) {
            this.transactionId = transactionId;
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

        public LocalDateTime getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
        }

        public LocalDateTime getSettledAt() {
            return settledAt;
        }

        public void setSettledAt(LocalDateTime settledAt) {
            this.settledAt = settledAt;
        }
    }
}