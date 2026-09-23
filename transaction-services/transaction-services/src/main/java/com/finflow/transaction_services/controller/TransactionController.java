package com.finflow.transaction_services.controller;

import java.util.List;
import java.util.UUID;
import org.springframework.security.access.prepost.PreAuthorize;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finflow.transaction_services.dto.request.TransferMoneyRequest;
import com.finflow.transaction_services.dto.response.TransactionResponse;
import com.finflow.transaction_services.service.TransactionService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/transactions")
@Validated
public class TransactionController {

	 private final TransactionService transactionService;

	    public TransactionController(TransactionService transactionService) {
	        this.transactionService = transactionService;
	    }

	    @PostMapping("/transfer")
	    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
	    public ResponseEntity<TransactionResponse> transferMoney(
	            @Valid @RequestBody TransferMoneyRequest request) {

	        return new ResponseEntity<>(
	                transactionService.transferMoney(request),
	                HttpStatus.CREATED);
	    }
	    @GetMapping("/{id}")
	    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
	    public ResponseEntity<TransactionResponse> getTransactionById(
	            @PathVariable UUID id) {

	        return ResponseEntity.ok(
	                transactionService.getTransactionById(id));
	    }

	    @GetMapping("/account/{accountId}")
	    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
	    public ResponseEntity<List<TransactionResponse>> getTransactionsByAccount(
	            @PathVariable UUID accountId) {

	        return ResponseEntity.ok(
	                transactionService.getTransactionsByAccount(accountId));
	    }

	    @GetMapping
	    @PreAuthorize("hasRole('ADMIN')")
	    public ResponseEntity<List<TransactionResponse>> getAllTransactions() {

	        return ResponseEntity.ok(
	                transactionService.getAllTransactions());
	    }
}
