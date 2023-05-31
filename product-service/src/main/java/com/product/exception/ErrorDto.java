package com.product.exception;

import lombok.Value;
import org.springframework.http.HttpStatus;
@Value
public class ErrorDto {
	 HttpStatus httpStatus;
     String message;
}
