package com.finflow.reconciliation_service.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finflow.reconciliation_service.entity.Reconciliation;

public interface ReconciliationRepository
        extends JpaRepository<Reconciliation, UUID> {

    Optional<Reconciliation> findByTransactionId(UUID transactionId);

    Optional<Reconciliation> findBySettlementId(UUID settlementId);
}