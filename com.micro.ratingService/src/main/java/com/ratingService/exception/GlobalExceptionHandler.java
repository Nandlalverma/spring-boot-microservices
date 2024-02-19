package com.ratingService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> exceptionHandler(ResourceNotFoundException ex){
		ApiResponse response = new ApiResponse();
		response.setMessage(ex.getMessage());
		response.setStatus(HttpStatus.NOT_FOUND);
		response.setSuccess(true);
		return new ResponseEntity<ApiResponse>(response,HttpStatus.NOT_FOUND);
	}
}
