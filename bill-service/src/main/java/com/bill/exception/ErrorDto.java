package com.bill.exception;

import org.springframework.http.HttpStatus;

import lombok.Value;
@Value
public class ErrorDto {
	 HttpStatus httpStatus;
     String message;
}
