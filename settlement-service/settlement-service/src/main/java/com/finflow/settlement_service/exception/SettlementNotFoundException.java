package com.finflow.settlement_service.exception;

public class SettlementNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public SettlementNotFoundException(String message) {
        super(message);
    }
}