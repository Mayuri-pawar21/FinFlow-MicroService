package com.finflow.transaction_services.service;

import java.util.List;
import java.util.UUID;

import com.finflow.transaction_services.dto.request.TransferMoneyRequest;
import com.finflow.transaction_services.dto.response.TransactionResponse;

public interface TransactionService {

	TransactionResponse transferMoney(TransferMoneyRequest request);

    TransactionResponse getTransactionById(UUID id);

    List<TransactionResponse> getTransactionsByAccount(UUID accountId);

    List<TransactionResponse> getAllTransactions();
}
