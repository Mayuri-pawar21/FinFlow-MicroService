package com.finflow.account_service.service;

import java.math.BigDecimal;
import java.util.List;

import java.util.UUID;

import com.finflow.account_service.dto.request.CreateAccountRequest;
import com.finflow.account_service.dto.request.UpdateAccountRequest;
import com.finflow.account_service.dto.response.AccountResponse;



public interface AccountService {

	AccountResponse createAccount(CreateAccountRequest request, String email);
	 List<AccountResponse> getAllAccounts();
	 AccountResponse getAccountById(UUID id);
	 AccountResponse updateAccount(UUID id, UpdateAccountRequest request);
	 AccountResponse closeAccount(UUID id);
	 List<AccountResponse> getAccountsByUser(String email);	
	 AccountResponse updateBalance(UUID id, BigDecimal amount);
}
