package com.felipesa.g_biblioteca.service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandleException {
	
	@ExceptionHandler({RuntimeException.class})
	public ResponseEntity<?> handleRuntimeException(RuntimeException e){
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
	}
	
	@ExceptionHandler({ResourceNotFoundException.class})
	public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException e){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	}
	
	@ExceptionHandler({ValidationErroException.class})
	public ResponseEntity<?> handleValidationErroException(ValidationErroException e){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	}
}
