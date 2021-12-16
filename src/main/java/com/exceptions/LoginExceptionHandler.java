

package com.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.entities.LoginErrorResponse;



@ControllerAdvice
public class LoginExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<LoginErrorResponse> handleException(InvalidCredentialsException exception) {
		LoginErrorResponse error = new LoginErrorResponse();
		
		//error.setStatus(HttpStatus.NOT_FOUND.value()); // 401
		error.setStatus(HttpStatus.UNAUTHORIZED.value());
		error.setMessage(exception.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
	}
	@ExceptionHandler
	public ResponseEntity<LoginErrorResponse> handleException(CustomerNotFoundException exception) {
		LoginErrorResponse error = new LoginErrorResponse();
		
		error.setStatus(HttpStatus.NOT_FOUND.value()); // 404
		error.setMessage(exception.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
}