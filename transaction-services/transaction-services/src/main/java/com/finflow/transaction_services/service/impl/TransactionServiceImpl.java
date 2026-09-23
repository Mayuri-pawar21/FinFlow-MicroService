package com.finflow.transaction_services.service.impl;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.finflow.transaction_services.client.AccountClient;
import com.finflow.transaction_services.dto.request.TransferMoneyRequest;
import com.finflow.transaction_services.dto.response.TransactionResponse;
import com.finflow.transaction_services.entity.Transaction;
import com.finflow.transaction_services.enums.CurrencyType;
import com.finflow.transaction_services.enums.TransactionStatus;
import com.finflow.transaction_services.enums.TransactionType;
import com.finflow.transaction_services.exception.InsufficientBalanceException;
import com.finflow.transaction_services.exception.InvalidTransactionException;
import com.finflow.transaction_services.exception.TransactionNotFoundException;
import com.finflow.transaction_services.mapper.TransactionMapper;
import com.finflow.transaction_services.repository.TransactionRepository;
import com.finflow.transaction_services.service.TransactionService;

import jakarta.transaction.Transactional;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final AccountClient accountClient;

    public TransactionServiceImpl(
            TransactionRepository transactionRepository,
            AccountClient accountClient) {

        this.transactionRepository = transactionRepository;
        this.accountClient = accountClient;
    }

    @Override
    @Transactional
    public TransactionResponse transferMoney(TransferMoneyRequest request) {

        // 1. Sender and receiver cannot be the same
        if (request.getSenderAccountId()
                .equals(request.getReceiverAccountId())) {

            throw new InvalidTransactionException(
                    "Sender and receiver accounts cannot be the same");
        }

        // 2. Amount must be positive
        if (request.getAmount() == null
                || request.getAmount().compareTo(BigDecimal.ZERO) <= 0) {

            throw new InvalidTransactionException(
                    "Transfer amount must be greater than zero");
        }

        // 3. Get sender and receiver accounts
        AccountClient.AccountResponse sender =
                accountClient.getAccount(request.getSenderAccountId());

        AccountClient.AccountResponse receiver =
                accountClient.getAccount(request.getReceiverAccountId());

        if (sender == null || receiver == null) {
            throw new InvalidTransactionException(
                    "Sender or receiver account not found");
        }

        // 4. Check sender status
        if (!"ACTIVE".equalsIgnoreCase(sender.getStatus())) {
            throw new InvalidTransactionException(
                    "Sender account is not active");
        }

        // 5. Check receiver status
        if (!"ACTIVE".equalsIgnoreCase(receiver.getStatus())) {
            throw new InvalidTransactionException(
                    "Receiver account is not active");
        }

        // 6. Check sufficient balance
        if (sender.getBalance().compareTo(request.getAmount()) < 0) {
            throw new InsufficientBalanceException(
                    "Insufficient balance in sender account");
        }

        // 7. Check currency
        if (!sender.getCurrency().equals(receiver.getCurrency())) {
            throw new InvalidTransactionException(
                    "Sender and receiver currency must be the same");
        }

        // 8. Debt sender
        accountClient.updateBalance(
                request.getSenderAccountId(),
                request.getAmount().negate());

        // 9. Credit receiver
        accountClient.updateBalance(
                request.getReceiverAccountId(),
                request.getAmount());

        // 10. Create transaction record
        Transaction transaction = new Transaction();

        transaction.setTransactionReference(
                "TXN-" + UUID.randomUUID());

        transaction.setSenderAccountId(
                request.getSenderAccountId());

        transaction.setReceiverAccountId(
                request.getReceiverAccountId());

        transaction.setAmount(
                request.getAmount());

        transaction.setCurrency(
                CurrencyType.valueOf(sender.getCurrency()));

        transaction.setStatus(
                TransactionStatus.COMPLETED);

        transaction.setType(
                TransactionType.TRANSFER);

        transaction.setCreatedAt(
                LocalDateTime.now());

        // 11. Save transaction
        Transaction savedTransaction =
                transactionRepository.save(transaction);

        // 12. Return response
        return TransactionMapper.toResponse(savedTransaction);
    }

    @Override
    public TransactionResponse getTransactionById(UUID id) {

        Transaction transaction =
                transactionRepository.findById(id)
                        .orElseThrow(() ->
                                new TransactionNotFoundException(
                                        "Transaction not found with ID: " + id));

        return TransactionMapper.toResponse(transaction);
    }

    @Override
    public List<TransactionResponse> getTransactionsByAccount(UUID accountId) {

        List<Transaction> transactions =
                new java.util.ArrayList<>(
                        transactionRepository.findBySenderAccountId(accountId)
                );

        transactions.addAll(
                transactionRepository.findByReceiverAccountId(accountId)
        );

        return transactions.stream()
                .map(TransactionMapper::toResponse)
                .toList();
    }

    @Override
    public List<TransactionResponse> getAllTransactions() {

        return transactionRepository.findAll()
                .stream()
                .map(TransactionMapper::toResponse)
                .toList();
    }
}