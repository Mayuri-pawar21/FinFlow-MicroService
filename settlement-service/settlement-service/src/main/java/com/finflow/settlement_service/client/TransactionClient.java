package com.finflow.settlement_service.client;

import java.util.UUID;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.finflow.settlement_service.config.FeignConfig;
import com.finflow.settlement_service.dto.response.TransactionResponse;

@FeignClient(
        name = "TRANSACTION-SERVICE",
        configuration = FeignConfig.class
)
public interface TransactionClient {

    @GetMapping("/api/transactions/{id}")
    TransactionResponse getTransactionById(
            @PathVariable UUID id);
}