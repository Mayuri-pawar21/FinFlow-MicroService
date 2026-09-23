package com.finflow.transaction_services.exception;

public class AccountNotFoundException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = -9011003887410053144L;

	public AccountNotFoundException(String message) {
        super(message);
    }
}
