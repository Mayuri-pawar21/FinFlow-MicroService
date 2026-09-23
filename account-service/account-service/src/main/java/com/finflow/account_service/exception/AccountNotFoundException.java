package com.finflow.account_service.exception;

public class AccountNotFoundException extends RuntimeException {

	   /**
	 * 
	 */
	private static final long serialVersionUID = -1816324372653910458L;

	   public AccountNotFoundException (String message) {
	        super(message);
	    }
}
