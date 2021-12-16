package com.exceptions;

public class InvalidProductInputException extends Exception {
	private static final long serialVersionUID = 1L;

	public InvalidProductInputException(String message) {
		super(message);
	}
}
