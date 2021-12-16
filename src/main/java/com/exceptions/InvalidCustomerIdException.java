package com.exceptions;

public class InvalidCustomerIdException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidCustomerIdException(String message) {
		super(message);
	}
}
