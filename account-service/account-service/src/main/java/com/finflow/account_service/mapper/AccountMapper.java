package com.finflow.account_service.mapper;

import com.finflow.account_service.dto.request.CreateAccountRequest;
import com.finflow.account_service.dto.response.AccountResponse;
import com.finflow.account_service.entity.Account;
import com.finflow.account_service.enums.AccountStatus;

public final class AccountMapper {
	
	


	 private AccountMapper() {
		super();
	}

	 public static Account toEntity(CreateAccountRequest request) {

	        Account account = new Account();

	        account.setAccountNumber(request.getAccountNumber());
	        account.setAccountHolderName(request.getAccountHolderName());
	        account.setBankCode(request.getBankCode());
	        account.setCurrency(request.getCurrency());
	        account.setBalance(request.getBalance());

	        // Business default
	        account.setStatus(AccountStatus.ACTIVE);

	        return account;
	    }

	    public static AccountResponse toResponse(Account account) {

	        return new AccountResponse(
	                account.getId(),
	                account.getAccountNumber(),
	                account.getAccountHolderName(),
	                account.getBankCode(),
	                account.getCurrency(),
	                account.getBalance(),
	                account.getStatus(),
	                account.getCreatedAt()
	        );
	    }
	    
	    
}
