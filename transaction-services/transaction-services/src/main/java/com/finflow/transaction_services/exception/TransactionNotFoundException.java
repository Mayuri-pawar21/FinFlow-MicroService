package com.finflow.transaction_services.exception;

public class TransactionNotFoundException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = -1784425327479663996L;

	public TransactionNotFoundException(String message) {
        super(message);
    }
}
