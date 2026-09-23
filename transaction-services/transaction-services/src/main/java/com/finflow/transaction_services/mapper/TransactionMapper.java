package com.finflow.transaction_services.mapper;

import com.finflow.transaction_services.dto.response.TransactionResponse;
import com.finflow.transaction_services.entity.Transaction;

public class TransactionMapper {

	private TransactionMapper() {
    }

    public static TransactionResponse toResponse(Transaction transaction) {

        TransactionResponse response = new TransactionResponse();

        response.setId(transaction.getId());
        response.setTransactionReference(transaction.getTransactionReference());
        response.setSenderAccountId(transaction.getSenderAccountId());
        response.setReceiverAccountId(transaction.getReceiverAccountId());
        response.setAmount(transaction.getAmount());
        response.setCurrency(transaction.getCurrency());
        response.setStatus(transaction.getStatus());
        response.setType(transaction.getType());
        response.setCreatedAt(transaction.getCreatedAt());

        return response;
    }
}
