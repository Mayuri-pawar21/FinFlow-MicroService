package com.finflow.reconciliation_service.service.impl;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.finflow.reconciliation_service.client.SettlementClient;
import com.finflow.reconciliation_service.client.TransactionClient;
import com.finflow.reconciliation_service.dto.request.CreateReconciliationRequest;
import com.finflow.reconciliation_service.dto.response.ReconciliationResponse;
import com.finflow.reconciliation_service.entity.Reconciliation;
import com.finflow.reconciliation_service.enums.ReconciliationStatus;
import com.finflow.reconciliation_service.exception.ReconciliationNotFoundException;
import com.finflow.reconciliation_service.mapper.ReconciliationMapper;
import com.finflow.reconciliation_service.repository.ReconciliationRepository;
import com.finflow.reconciliation_service.service.ReconciliationService;

@Service
public class ReconciliationServiceImpl implements ReconciliationService {

	private final ReconciliationRepository reconciliationRepository;
	private final TransactionClient transactionClient;
	private final SettlementClient settlementClient;

	public ReconciliationServiceImpl(
	        ReconciliationRepository reconciliationRepository,
	        TransactionClient transactionClient,
	        SettlementClient settlementClient) {

	    this.reconciliationRepository = reconciliationRepository;
	    this.transactionClient = transactionClient;
	    this.settlementClient = settlementClient;
	}

	@Override
	public ReconciliationResponse createReconciliation(
	        CreateReconciliationRequest request) {

	    // 1. Get transaction details
	    TransactionClient.TransactionResponse transaction =
	            transactionClient.getTransactionById(
	                    request.getTransactionId());

	    // 2. Get settlement details
	    SettlementClient.SettlementResponse settlement =
	            settlementClient.getSettlementById(
	                    request.getSettlementId());

	    // 3. Get amounts
	    BigDecimal expectedAmount =
	            transaction.getAmount();

	    BigDecimal actualAmount =
	            settlement.getAmount();

	    // 4. Calculate difference
	    BigDecimal difference =
	            expectedAmount.subtract(actualAmount);

	    // 5. Create reconciliation entity
	    Reconciliation reconciliation =
	            new Reconciliation();

	    reconciliation.setTransactionId(
	            request.getTransactionId());

	    reconciliation.setSettlementId(
	            request.getSettlementId());

	    reconciliation.setExpectedAmount(
	            expectedAmount);

	    reconciliation.setActualAmount(
	            actualAmount);

	    reconciliation.setDifference(
	            difference);

	    // 6. Determine reconciliation status
	    if (difference.compareTo(BigDecimal.ZERO) == 0) {

	        reconciliation.setStatus(
	                ReconciliationStatus.MATCHED);

	    } else {

	        reconciliation.setStatus(
	                ReconciliationStatus.MISMATCH);
	    }

	    // 7. Set creation time
	    reconciliation.setCreatedAt(
	            LocalDateTime.now());

	    // 8. Save
	    Reconciliation saved =
	            reconciliationRepository.save(reconciliation);

	    // 9. Convert to response
	    return ReconciliationMapper.toResponse(saved);
	}

    @Override
    public ReconciliationResponse getReconciliationById(UUID id) {

        Reconciliation reconciliation =
                reconciliationRepository.findById(id)
                        .orElseThrow(() ->
                                new ReconciliationNotFoundException(
                                        "Reconciliation not found with ID: " + id));

        return ReconciliationMapper.toResponse(reconciliation);
    }

    @Override
    public ReconciliationResponse getReconciliationByTransactionId(
            UUID transactionId) {

        Reconciliation reconciliation =
                reconciliationRepository.findByTransactionId(transactionId)
                        .orElseThrow(() ->
                                new ReconciliationNotFoundException(
                                        "Reconciliation not found for transaction ID: "
                                                + transactionId));

        return ReconciliationMapper.toResponse(reconciliation);
    }

    @Override
    public List<ReconciliationResponse> getAllReconciliations() {

        return reconciliationRepository.findAll()
                .stream()
                .map(ReconciliationMapper::toResponse)
                .toList();
    }
}