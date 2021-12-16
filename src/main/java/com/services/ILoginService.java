package com.services;

import com.dto.LoginDto;
import com.entities.Login;
import com.exceptions.InvalidCredentialsException;

public interface ILoginService {
	
	LoginDto login(Login login) throws InvalidCredentialsException;
	LoginDto logout(String id) throws InvalidCredentialsException;

}