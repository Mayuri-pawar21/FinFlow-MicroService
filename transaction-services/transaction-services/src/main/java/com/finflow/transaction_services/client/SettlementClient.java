package com.finflow.transaction_services.client;

import java.math.BigDecimal;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import jakarta.servlet.http.HttpServletRequest;

@Component
public class SettlementClient {

    private final RestClient restClient;
    private final HttpServletRequest request;

    public SettlementClient(
            RestClient restClient,
            HttpServletRequest request) {

        this.restClient = restClient;
        this.request = request;
    }

    public SettlementResponse createSettlement(
            UUID transactionId,
            BigDecimal amount,
            String currency) {

        CreateSettlementRequest settlementRequest =
                new CreateSettlementRequest(
                        transactionId,
                        amount,
                        currency);

        return restClient.post()
                .uri("http://SETTLEMENT-SERVICE/api/settlements")
                .header(
                        "Authorization",
                        request.getHeader("Authorization"))
                .header(
                        "X-User-Email",
                        request.getHeader("X-User-Email"))
                .header(
                        "X-User-Role",
                        request.getHeader("X-User-Role"))
                .body(settlementRequest)
                .retrieve()
                .body(SettlementResponse.class);
    }

    public static class CreateSettlementRequest {

        private UUID transactionId;
        private BigDecimal amount;
        private String currency;

        public CreateSettlementRequest() {
        }

        public CreateSettlementRequest(
                UUID transactionId,
                BigDecimal amount,
                String currency) {

            this.transactionId = transactionId;
            this.amount = amount;
            this.currency = currency;
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
    }

    public static class SettlementResponse {

        private UUID id;
        private UUID transactionId;
        private BigDecimal amount;
        private String currency;
        private String status;

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
    }
}