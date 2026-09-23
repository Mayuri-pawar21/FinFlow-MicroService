package com.finflow.reconciliation_service.exception;

public class ReconciliationNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ReconciliationNotFoundException(String message) {
        super(message);
    }
}