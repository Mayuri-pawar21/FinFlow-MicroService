package com.finflow.account_service.exception;

public class AccountAlreadyClosedException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6960193709433574408L;

	public AccountAlreadyClosedException(String message) {
        super(message);
    }
}
