package com.felipesa.g_biblioteca.service.exceptions;

public class ValidationErroException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public ValidationErroException(String message) {
		super(message);
	}
}
