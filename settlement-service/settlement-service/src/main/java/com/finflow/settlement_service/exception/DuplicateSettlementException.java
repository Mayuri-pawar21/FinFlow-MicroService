package com.finflow.settlement_service.exception;

public class DuplicateSettlementException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public DuplicateSettlementException(String message) {
        super(message);
    }
}