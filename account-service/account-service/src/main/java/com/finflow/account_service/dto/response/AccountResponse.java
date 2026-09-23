package com.finflow.account_service.dto.response;

import java.math.BigDecimal;

import java.time.LocalDateTime;
import java.util.UUID;

import com.finflow.account_service.enums.AccountStatus;
import com.finflow.account_service.enums.CurrencyType;



public class AccountResponse {

	 private UUID id;
	    private String accountNumber;
	    private String accountHolderName;
	    private String bankCode;
	    private CurrencyType currency;
	    private BigDecimal balance;
	    private AccountStatus status;
	    private LocalDateTime createdAt;

	    public AccountResponse() {
	    }

	    public AccountResponse(UUID id, String accountNumber, String accountHolderName,
	            String bankCode, CurrencyType currency,
	            BigDecimal balance, AccountStatus status,
	            LocalDateTime createdAt) {

	        this.id = id;
	        this.accountNumber = accountNumber;
	        this.accountHolderName = accountHolderName;
	        this.bankCode = bankCode;
	        this.currency = currency;
	        this.balance = balance;
	        this.status = status;
	        this.createdAt = createdAt;
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

		public CurrencyType getCurrency() {
			return currency;
		}

		public void setCurrency(CurrencyType currency) {
			this.currency = currency;
		}

		public BigDecimal getBalance() {
			return balance;
		}

		public void setBalance(BigDecimal balance) {
			this.balance = balance;
		}

		public AccountStatus getStatus() {
			return status;
		}

		public void setStatus(AccountStatus status) {
			this.status = status;
		}

		public LocalDateTime getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(LocalDateTime createdAt) {
			this.createdAt = createdAt;
		}

	    
}
