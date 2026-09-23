package com.finflow.transaction_services.client;

import java.math.BigDecimal;
import java.util.UUID;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import jakarta.servlet.http.HttpServletRequest;

@Component
public class AccountClient {

	 private final RestClient restClient;
	    private final HttpServletRequest request;

	    public AccountClient(
	            @LoadBalanced RestClient.Builder restClientBuilder,
	            HttpServletRequest request) {

	        this.restClient = restClientBuilder.build();
	        this.request = request;
	    }
	    public AccountResponse getAccount(UUID accountId) {

	        return restClient.get()
	                .uri(
	                    "http://ACCOUNT-SERVICE/api/accounts/{id}",
	                    accountId
	                )
	                .header(
	                    "Authorization",
	                    request.getHeader("Authorization")
	                )
	                .header(
	                    "X-User-Email",
	                    request.getHeader("X-User-Email")
	                )
	                .header(
	                    "X-User-Role",
	                    request.getHeader("X-User-Role")
	                )
	                .retrieve()
	                .body(AccountResponse.class);
	    }
	    public AccountResponse updateBalance(
	            UUID accountId,
	            BigDecimal amount) {

	        return restClient.patch()
	                .uri(
	                    "http://ACCOUNT-SERVICE/api/accounts/{id}/balance",
	                    accountId
	                )
	                .header(
	                    "Authorization",
	                    request.getHeader("Authorization")
	                )
	                .header(
	                    "X-User-Email",
	                    request.getHeader("X-User-Email")
	                )
	                .header(
	                    "X-User-Role",
	                    request.getHeader("X-User-Role")
	                )
	                .body(new BalanceUpdateRequest(amount))
	                .retrieve()
	                .body(AccountResponse.class);
	    }
    public static class BalanceUpdateRequest {

        private BigDecimal amount;

        public BalanceUpdateRequest() {
        }

        public BalanceUpdateRequest(BigDecimal amount) {
            this.amount = amount;
        }

        public BigDecimal getAmount() {
            return amount;
        }

        public void setAmount(BigDecimal amount) {
            this.amount = amount;
        }
    }

    public static class AccountResponse {

        private UUID id;
        private String accountNumber;
        private String accountHolderName;
        private String bankCode;
        private String currency;
        private BigDecimal balance;
        private String status;
        private String userEmail;

        public AccountResponse() {
        }

        public UUID getId() {
            return id;
        }

        public void setId(UUID id) {
            this.id = id;
        }

        public String getAccountNumber() {
            return accountNumber;
        }

        public void setAccountNumber(String accountNumber) {
            this.accountNumber = accountNumber;
        }

        public String getAccountHolderName() {
            return accountHolderName;
        }

        public void setAccountHolderName(String accountHolderName) {
            this.accountHolderName = accountHolderName;
        }

        public String getBankCode() {
            return bankCode;
        }

        public void setBankCode(String bankCode) {
            this.bankCode = bankCode;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public BigDecimal getBalance() {
            return balance;
        }

        public void setBalance(BigDecimal balance) {
            this.balance = balance;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getUserEmail() {
            return userEmail;
        }

        public void setUserEmail(String userEmail) {
            this.userEmail = userEmail;
        }
    }
}