package com.product.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
@Getter
public class ValidationException extends RuntimeException{
	
  private HttpStatus httpStatus;

	public ValidationException(String message,HttpStatus httpStatus) {
		super(message);
		this.httpStatus = httpStatus;
		
	}
  
}
