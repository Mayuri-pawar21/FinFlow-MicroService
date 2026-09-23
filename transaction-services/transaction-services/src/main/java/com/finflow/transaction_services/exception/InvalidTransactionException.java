package com.finflow.transaction_services.exception;

public class InvalidTransactionException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 5230436412062709516L;

	public InvalidTransactionException(String message) {
        super(message);
    }
}
