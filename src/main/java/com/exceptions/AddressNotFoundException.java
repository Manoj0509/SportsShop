package com.exceptions;

//
public class AddressNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public AddressNotFoundException(String message) {
		super(message);
	}
}
