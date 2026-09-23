package com.finflow.account_service.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.finflow.account_service.dto.request.CreateAccountRequest;
import com.finflow.account_service.dto.request.UpdateAccountRequest;
import com.finflow.account_service.dto.response.AccountResponse;
import com.finflow.account_service.entity.Account;
import com.finflow.account_service.enums.AccountStatus;
import com.finflow.account_service.exception.AccountAlreadyClosedException;
import com.finflow.account_service.exception.AccountNotFoundException;
import com.finflow.account_service.exception.DuplicateAccountException;
import com.finflow.account_service.mapper.AccountMapper;
import com.finflow.account_service.repository.AccountRepository;
import com.finflow.account_service.service.AccountService;


@Service
public class AccountServiceImpl implements AccountService {

	private final AccountRepository accountRepository;
	

	private AccountServiceImpl(AccountRepository accountRepository) {
		super();
		this.accountRepository = accountRepository;
	}
	
	
	@Override
	public AccountResponse createAccount(CreateAccountRequest request, String email) {
		  if (accountRepository.existsByAccountNumber(request.getAccountNumber())) {
			  throw new DuplicateAccountException(
				        "Account number " + request.getAccountNumber() + " already exists");
		    }

		    Account account = AccountMapper.toEntity(request);
		    account.setUserEmail(email);

		    Account savedAccount = accountRepository.save(account);

		    return AccountMapper.toResponse(savedAccount);

	}


	@Override
	public List<AccountResponse> getAllAccounts() {

		List<Account> accounts = accountRepository.findAll();
		  return accounts.stream()
		            .map(AccountMapper::toResponse)
		            .toList();
	}


	@Override
	public AccountResponse getAccountById(UUID id) {
		 Account account = accountRepository.findById(id)
		            .orElseThrow(() ->
		                    new AccountNotFoundException("Account not found with ID: " + id));

		    return AccountMapper.toResponse(account);
	}


	@Override
	public AccountResponse updateAccount(UUID id, UpdateAccountRequest request) {
		 Account account = accountRepository.findById(id)
		            .orElseThrow(() ->
		                    new AccountNotFoundException("Account not found with ID: " + id));

		    account.setAccountHolderName(request.getAccountHolderName());
		    account.setBankCode(request.getBankCode());
		    account.setCurrency(request.getCurrency());

		    Account updatedAccount = accountRepository.save(account);

		    return AccountMapper.toResponse(updatedAccount);
	}


	@Override
	public AccountResponse closeAccount(UUID id) {
		Account account = accountRepository.findById(id)
	            .orElseThrow(() ->
	                    new AccountNotFoundException("Account not found with ID: " + id));

	    if (account.getStatus() == AccountStatus.CLOSED) {
	        throw new AccountAlreadyClosedException(
	                "Account is already closed.");
	    }

	    account.setStatus(AccountStatus.CLOSED);

	    Account updatedAccount = accountRepository.save(account);

	    return AccountMapper.toResponse(updatedAccount);
	}


	@Override
	public List<AccountResponse> getAccountsByUser(String email) {

		System.out.println("Logged in email = " + email);
	    return accountRepository.findByUserEmail(email)
	            .stream()
	            .map(AccountMapper::toResponse)
	            .toList();
	}


	@Override
	public AccountResponse updateBalance(UUID id, BigDecimal amount) {
		Account account = accountRepository.findById(id)
	            .orElseThrow(() ->
	                    new AccountNotFoundException(
	                            "Account not found with ID: " + id));

	    BigDecimal newBalance = account.getBalance().add(amount);

	    if (newBalance.compareTo(BigDecimal.ZERO) < 0) {
	        throw new IllegalArgumentException("Insufficient balance");
	    }

	    account.setBalance(newBalance);

	    Account updatedAccount = accountRepository.save(account);

	    return AccountMapper.toResponse(updatedAccount);
	}
	
	
	
	

}

