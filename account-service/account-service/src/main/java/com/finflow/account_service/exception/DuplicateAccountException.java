package com.finflow.account_service.exception;

public class DuplicateAccountException extends RuntimeException {
	 /**
	 * 
	 */
	private static final long serialVersionUID = -5711875658135704670L;

	 public DuplicateAccountException(String message) {
	        super(message);
	    }
}
