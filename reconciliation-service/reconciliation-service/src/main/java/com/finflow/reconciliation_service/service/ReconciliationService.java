package com.finflow.reconciliation_service.service;

import java.util.List;
import java.util.UUID;

import com.finflow.reconciliation_service.dto.request.CreateReconciliationRequest;
import com.finflow.reconciliation_service.dto.response.ReconciliationResponse;

public interface ReconciliationService {

    ReconciliationResponse createReconciliation(
            CreateReconciliationRequest request);

    ReconciliationResponse getReconciliationById(UUID id);

    ReconciliationResponse getReconciliationByTransactionId(
            UUID transactionId);

    List<ReconciliationResponse> getAllReconciliations();
}