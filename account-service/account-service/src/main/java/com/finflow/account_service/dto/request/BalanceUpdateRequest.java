package com.finflow.account_service.dto.request;

import java.math.BigDecimal;

public class BalanceUpdateRequest {

	 private BigDecimal amount;

	    public BalanceUpdateRequest() {
	    }

	    public BigDecimal getAmount() {
	        return amount;
	    }

	    public void setAmount(BigDecimal amount) {
	        this.amount = amount;
	    }
}
