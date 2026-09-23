package com.finflow.account_service.exception;

import java.time.LocalDateTime;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	  @ExceptionHandler(DuplicateAccountException.class)
	    public ResponseEntity<ErrorResponse> handleDuplicateAccountException(
	            DuplicateAccountException ex) {

	        ErrorResponse errorResponse = new ErrorResponse(
	                LocalDateTime.now(),
	                HttpStatus.CONFLICT.value(),
	                "Duplicate Account",
	                ex.getMessage());

	        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
}
	  @ExceptionHandler(AccountNotFoundException.class)
	  public ResponseEntity<ErrorResponse> handleAccountNotFound(AccountNotFoundException ex) {

	      ErrorResponse error = new ErrorResponse(
	              LocalDateTime.now(),
	              HttpStatus.NOT_FOUND.value(),
	              "Not Found",
	              ex.getMessage()
	      );

	      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	  }
	  @ExceptionHandler(AccountAlreadyClosedException.class)
	  public ResponseEntity<ErrorResponse> handleAccountAlreadyClosed(AccountAlreadyClosedException ex) {

	      ErrorResponse error = new ErrorResponse(
	              LocalDateTime.now(),
	              HttpStatus.BAD_REQUEST.value(),
	              "Bad Request",
	              ex.getMessage()
	      );

	      return ResponseEntity.badRequest().body(error);
	  }
	
	
	  @ExceptionHandler(IllegalArgumentException.class)
	  public ResponseEntity<String> handleIllegalArgumentException(
	          IllegalArgumentException ex) {

	      return ResponseEntity
	              .status(HttpStatus.BAD_REQUEST)
	              .body(ex.getMessage());
	  }
	  
	 
	  
}
