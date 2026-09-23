package com.finflow.settlement_service.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finflow.settlement_service.client.TransactionClient;
import com.finflow.settlement_service.dto.request.CreateSettlementRequest;
import com.finflow.settlement_service.dto.response.SettlementResponse;
import com.finflow.settlement_service.dto.response.TransactionResponse;
import com.finflow.settlement_service.entity.Settlement;
import com.finflow.settlement_service.enums.SettlementStatus;
import com.finflow.settlement_service.exception.DuplicateSettlementException;
import com.finflow.settlement_service.exception.SettlementNotFoundException;
import com.finflow.settlement_service.mapper.SettlementMapper;
import com.finflow.settlement_service.repository.SettlementRepository;
import com.finflow.settlement_service.service.SettlementService;

@Service
public class SettlementServiceImpl implements SettlementService {

    private final SettlementRepository settlementRepository;
    private final TransactionClient transactionClient;

   

    public SettlementServiceImpl(SettlementRepository settlementRepository, TransactionClient transactionClient) {
		super();
		this.settlementRepository = settlementRepository;
		this.transactionClient = transactionClient;
	}

    @Override
    @Transactional
    public SettlementResponse createSettlement(
            CreateSettlementRequest request) {

        // 1. Get transaction from Transaction Service
        TransactionResponse transaction =
                transactionClient.getTransactionById(
                        request.getTransactionId());

        // 2. Check if settlement already exists
        if (settlementRepository
                .existsByTransactionId(request.getTransactionId())) {

            throw new DuplicateSettlementException(
                    "Settlement already exists for transaction: "
                            + request.getTransactionId());
        }

        // 3. Validate amount
        if (request.getAmount()
                .compareTo(transaction.getAmount()) != 0) {

            throw new IllegalArgumentException(
                    "Settlement amount does not match transaction amount");
        }

        // 4. Validate currency
        if (!request.getCurrency()
                .equals(transaction.getCurrency())) {

            throw new IllegalArgumentException(
                    "Settlement currency does not match transaction currency");
        }

        // 5. Create settlement
        Settlement settlement =
                SettlementMapper.toEntity(request);

        settlement.setStatus(SettlementStatus.PENDING);
        settlement.setCreatedAt(LocalDateTime.now());

        // 6. Save
        Settlement savedSettlement =
                settlementRepository.save(settlement);

        // 7. Return response
        return SettlementMapper.toResponse(savedSettlement);
    }

    @Override
    public SettlementResponse getSettlementById(UUID id) {

        Settlement settlement =
                settlementRepository.findById(id)
                        .orElseThrow(() ->
                                new SettlementNotFoundException(
                                        "Settlement not found with ID: "
                                                + id));

        return SettlementMapper.toResponse(settlement);
    }

    @Override
    public SettlementResponse getSettlementByTransactionId(
            UUID transactionId) {

        Settlement settlement =
                settlementRepository
                        .findByTransactionId(transactionId)
                        .orElseThrow(() ->
                                new SettlementNotFoundException(
                                        "Settlement not found for transaction: "
                                                + transactionId));

        return SettlementMapper.toResponse(settlement);
    }

    @Override
    public List<SettlementResponse> getAllSettlements() {

        return settlementRepository.findAll()
                .stream()
                .map(SettlementMapper::toResponse)
                .toList();
    }
    
    @Override
    @Transactional
    public SettlementResponse processSettlement(UUID settlementId) {

        // 1. Find the settlement
        Settlement settlement =
                settlementRepository.findById(settlementId)
                        .orElseThrow(() ->
                                new SettlementNotFoundException(
                                        "Settlement not found with ID: "
                                                + settlementId));

        // 2. Get the related transaction
        TransactionResponse transaction =
                transactionClient.getTransactionById(
                        settlement.getTransactionId());

        // 3. Compare amount
        boolean amountMatches =
                settlement.getAmount()
                        .compareTo(transaction.getAmount()) == 0;

        boolean currencyMatches =
                settlement.getCurrency()
                        .equals(transaction.getCurrency());

        // 5. If everything matches → settle
        if (amountMatches && currencyMatches) {

            settlement.setStatus(SettlementStatus.SETTLED);
            settlement.setSettledAt(LocalDateTime.now());

        } else {

            settlement.setStatus(SettlementStatus.FAILED);
        }

        // 6. Save updated settlement
        Settlement savedSettlement =
                settlementRepository.save(settlement);

        // 7. Return response
        return SettlementMapper.toResponse(savedSettlement);
    }
}