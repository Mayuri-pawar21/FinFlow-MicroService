package com.finflow.settlement_service.mapper;

import com.finflow.settlement_service.dto.request.CreateSettlementRequest;
import com.finflow.settlement_service.dto.response.SettlementResponse;
import com.finflow.settlement_service.entity.Settlement;

public class SettlementMapper {

    private SettlementMapper() {
    }

    public static Settlement toEntity(CreateSettlementRequest request) {

        Settlement settlement = new Settlement();

        settlement.setTransactionId(request.getTransactionId());
        settlement.setAmount(request.getAmount());
        settlement.setCurrency(request.getCurrency());

        return settlement;
    }

    public static SettlementResponse toResponse(Settlement settlement) {

        SettlementResponse response = new SettlementResponse();

        response.setId(settlement.getId());
        response.setTransactionId(settlement.getTransactionId());
        response.setAmount(settlement.getAmount());
        response.setCurrency(settlement.getCurrency());
        response.setStatus(settlement.getStatus());
        response.setCreatedAt(settlement.getCreatedAt());
        response.setSettledAt(settlement.getSettledAt());

        return response;
    }
}	