package com.finflow.reconciliation_service.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finflow.reconciliation_service.dto.request.CreateReconciliationRequest;
import com.finflow.reconciliation_service.dto.response.ReconciliationResponse;
import com.finflow.reconciliation_service.service.ReconciliationService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/reconciliations")
@Validated
public class ReconciliationController {

    private final ReconciliationService reconciliationService;

    public ReconciliationController(
            ReconciliationService reconciliationService) {
        this.reconciliationService = reconciliationService;
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ReconciliationResponse> createReconciliation(
            @Valid @RequestBody CreateReconciliationRequest request) {

        return new ResponseEntity<>(
                reconciliationService.createReconciliation(request),
                HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<ReconciliationResponse> getReconciliationById(
            @PathVariable UUID id) {

        return ResponseEntity.ok(
                reconciliationService.getReconciliationById(id));
    }

    @GetMapping("/transaction/{transactionId}")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<ReconciliationResponse>
            getReconciliationByTransactionId(
                    @PathVariable UUID transactionId) {

        return ResponseEntity.ok(
                reconciliationService
                        .getReconciliationByTransactionId(transactionId));
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<ReconciliationResponse>>
            getAllReconciliations() {

        return ResponseEntity.ok(
                reconciliationService.getAllReconciliations());
    }
}