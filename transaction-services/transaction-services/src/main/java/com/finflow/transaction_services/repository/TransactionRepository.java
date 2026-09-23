package com.finflow.transaction_services.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finflow.transaction_services.entity.Transaction;
import com.finflow.transaction_services.enums.TransactionStatus;

@Repository
public interface TransactionRepository  extends JpaRepository<Transaction, UUID>{

	 Optional<Transaction> findByTransactionReference(String transactionReference);

	    boolean existsByTransactionReference(String transactionReference);

	    List<Transaction> findBySenderAccountId(UUID senderAccountId);

	    List<Transaction> findByReceiverAccountId(UUID receiverAccountId);

	    List<Transaction> findByStatus(TransactionStatus status);
}
