package com.finflow.settlement_service.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finflow.settlement_service.entity.Settlement;
import com.finflow.settlement_service.enums.SettlementStatus;

@Repository
public interface SettlementRepository   extends JpaRepository<Settlement, UUID> {

	  Optional<Settlement> findByTransactionId(UUID transactionId);

	    boolean existsByTransactionId(UUID transactionId);

	    List<Settlement> findByStatus(SettlementStatus status);
}
