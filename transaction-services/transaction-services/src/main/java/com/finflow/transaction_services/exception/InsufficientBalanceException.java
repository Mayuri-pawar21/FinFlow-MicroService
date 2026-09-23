package com.finflow.transaction_services.exception;

public class InsufficientBalanceException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1363997117639900055L;

	public InsufficientBalanceException(String message) {
        super(message);
    }
}
