package com.finflow.reconciliation_service.mapper;

import com.finflow.reconciliation_service.dto.request.CreateReconciliationRequest;
import com.finflow.reconciliation_service.dto.response.ReconciliationResponse;
import com.finflow.reconciliation_service.entity.Reconciliation;

public class ReconciliationMapper {

    private ReconciliationMapper() {
    }

    public static Reconciliation toEntity(CreateReconciliationRequest request) {

        Reconciliation reconciliation = new Reconciliation();

        reconciliation.setTransactionId(request.getTransactionId());
        reconciliation.setSettlementId(request.getSettlementId());

        return reconciliation;
    }

    public static ReconciliationResponse toResponse(
            Reconciliation reconciliation) {

        ReconciliationResponse response = new ReconciliationResponse();

        response.setId(reconciliation.getId());
        response.setTransactionId(reconciliation.getTransactionId());
        response.setSettlementId(reconciliation.getSettlementId());
        response.setExpectedAmount(reconciliation.getExpectedAmount());
        response.setActualAmount(reconciliation.getActualAmount());
        response.setDifference(reconciliation.getDifference());
        response.setStatus(reconciliation.getStatus());
        response.setCreatedAt(reconciliation.getCreatedAt());

        return response;
    }
}