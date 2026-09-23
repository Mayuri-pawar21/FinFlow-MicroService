package com.finflow.account_service.dto.request;

import java.math.BigDecimal;

import com.finflow.account_service.enums.CurrencyType;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class CreateAccountRequest {

	
	 @NotBlank(message = "Account number is required")
	    private String accountNumber;

	    @NotBlank(message = "Account holder name is required")
	    private String accountHolderName;

	    @NotBlank(message = "Bank code is required")
	    private String bankCode;

	    @NotNull(message = "Currency is required")
	    private CurrencyType currency;

	    @NotNull(message = "Balance is required")
	    @Positive(message = "Balance must be greater than zero")
	    private BigDecimal balance;

	    public CreateAccountRequest() {
	    }

	    public CreateAccountRequest(String accountNumber, String accountHolderName,
	            String bankCode, CurrencyType currency, BigDecimal balance) {

	        this.accountNumber = accountNumber;
	        this.accountHolderName = accountHolderName;
	        this.bankCode = bankCode;
	        this.currency = currency;
	        this.balance = balance;
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
	    
	    
}
