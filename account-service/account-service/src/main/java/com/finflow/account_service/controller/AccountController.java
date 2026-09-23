package com.finflow.account_service.controller;


import java.util.List;


import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finflow.account_service.dto.request.BalanceUpdateRequest;
import com.finflow.account_service.dto.request.CreateAccountRequest;
import com.finflow.account_service.dto.request.UpdateAccountRequest;
import com.finflow.account_service.dto.response.AccountResponse;
import com.finflow.account_service.service.AccountService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/accounts")
@Validated
public class AccountController {

	private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<AccountResponse> createAccount(
    		@RequestHeader("X-User-Email") String email,
            @Valid @RequestBody CreateAccountRequest request) {

        AccountResponse response = accountService.createAccount(request, email);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    
    @GetMapping
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public ResponseEntity<List<AccountResponse>> getAllAccounts(
            @RequestHeader("X-User-Email") String email) {

        return ResponseEntity.ok(accountService.getAccountsByUser(email));

    }
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public ResponseEntity<AccountResponse> getAccountById(@PathVariable UUID id) {

        return ResponseEntity.ok(accountService.getAccountById(id));

    }
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<AccountResponse> updateAccount(
            @PathVariable UUID id,
            @Valid @RequestBody UpdateAccountRequest request) {

        return ResponseEntity.ok(accountService.updateAccount(id, request));
    }
    
    @PatchMapping("/{id}/close")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<AccountResponse> closeAccount(@PathVariable UUID id) {

        return ResponseEntity.ok(accountService.closeAccount(id));
    }
    @PatchMapping("/{id}/balance")
    public ResponseEntity<AccountResponse> updateBalance(
            @PathVariable UUID id,
            @RequestBody BalanceUpdateRequest request) {

        return ResponseEntity.ok(
                accountService.updateBalance(id, request.getAmount())
        );
    }
}
