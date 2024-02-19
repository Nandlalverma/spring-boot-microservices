package com.userService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> handleGlobalException(ResourceNotFoundException ex){
		String response=ex.getMessage();
	   ApiResponse apires = new ApiResponse();
	   apires.setMessage(response);
	   apires.setStatus(HttpStatus.NOT_FOUND);
	   apires.setSuccess(true);
	   return new ResponseEntity<ApiResponse>(apires,HttpStatus.NOT_FOUND);
	   	
	}

}
