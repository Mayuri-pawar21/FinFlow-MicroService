package com.finflow.settlement_service.service;

import java.util.List;
import java.util.UUID;

import com.finflow.settlement_service.dto.request.CreateSettlementRequest;
import com.finflow.settlement_service.dto.response.SettlementResponse;

public interface SettlementService {

    SettlementResponse createSettlement(CreateSettlementRequest request);

    SettlementResponse getSettlementById(UUID id);

    SettlementResponse getSettlementByTransactionId(UUID transactionId);

    List<SettlementResponse> getAllSettlements();
    
    SettlementResponse processSettlement(UUID settlementId);
}