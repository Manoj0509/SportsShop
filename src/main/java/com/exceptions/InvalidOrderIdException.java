package com.exceptions;

public class InvalidOrderIdException extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidOrderIdException(String message) {
		super(message);
	}
}
