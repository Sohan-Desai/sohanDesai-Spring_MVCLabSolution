package com.greatlearning.order.exception;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.AllArgsConstructor;
import lombok.Getter;

@RestControllerAdvice
@Component
public class GlobalExceptionHandler {

	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public Error handleInvalidOrderId(IllegalArgumentException exception) {
		return new Error(100, exception.getMessage());
	}
}

@AllArgsConstructor
@Getter
class Error {
	private int id;
	private String message;
}