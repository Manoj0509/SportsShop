package com.exceptions;

public class CustomerNotFoundException extends Exception {

	// a universal version identifier for a Serializable class.
	private static final long serialVersionUID = 1L;

	public CustomerNotFoundException(String message) {
		super(message);
	}
}
