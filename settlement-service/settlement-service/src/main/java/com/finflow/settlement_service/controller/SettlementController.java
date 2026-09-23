package com.finflow.settlement_service.controller;

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

import com.finflow.settlement_service.dto.request.CreateSettlementRequest;
import com.finflow.settlement_service.dto.response.SettlementResponse;
import com.finflow.settlement_service.service.SettlementService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/settlements")
@Validated
public class SettlementController {

    private final SettlementService settlementService;

    public SettlementController(SettlementService settlementService) {
        this.settlementService = settlementService;
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<SettlementResponse> createSettlement(
            @Valid @RequestBody CreateSettlementRequest request) {

        return new ResponseEntity<>(
                settlementService.createSettlement(request),
                HttpStatus.CREATED);
    }

    @PostMapping("/{id}/process")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<SettlementResponse> processSettlement(
            @PathVariable UUID id) {

        return ResponseEntity.ok(
                settlementService.processSettlement(id));
    }
    
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<SettlementResponse> getSettlementById(
            @PathVariable UUID id) {

        return ResponseEntity.ok(
                settlementService.getSettlementById(id));
    }

    @GetMapping("/transaction/{transactionId}")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<SettlementResponse>
            getSettlementByTransactionId(
                    @PathVariable UUID transactionId) {

        return ResponseEntity.ok(
                settlementService
                        .getSettlementByTransactionId(transactionId));
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<SettlementResponse>>
            getAllSettlements() {

        return ResponseEntity.ok(
                settlementService.getAllSettlements());
    }
}