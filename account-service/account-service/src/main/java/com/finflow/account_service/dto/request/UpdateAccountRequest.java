package com.finflow.account_service.dto.request;






import com.finflow.account_service.enums.CurrencyType;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class UpdateAccountRequest {

	  @NotBlank(message = "Account holder name is required")
	    private String accountHolderName;

	    @NotBlank(message = "Bank code is required")
	    private String bankCode;

	    @NotNull(message = "Currency is required")
	    private CurrencyType currency;

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

	

	    
	    
}
