package com.services;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.repository.ILoginRepository;
import com.dto.LoginDto;
import com.entities.Login;
import com.exceptions.InvalidCredentialsException;

@Service
public class LoginServiceImpl implements ILoginService {

	@Autowired
	ILoginRepository loginRepo;
	
	private static Logger logger = LogManager.getLogger();

	@Override
	public LoginDto login(Login login) throws InvalidCredentialsException {
		Optional<Login> opt = loginRepo.findByUsrName(login.getUsername());
		if(!opt.isPresent()) {
			throw new InvalidCredentialsException("Invalid Credentials");
		}
		Login dbLogin = opt.get();
		if(login.getUsername().equalsIgnoreCase(dbLogin.getUsername()) && 
				login.getPassword().equalsIgnoreCase(dbLogin.getPassword())  && 
				login.getRole().equalsIgnoreCase(dbLogin.getRole())) {
			// set isLoggedIn flag to true
			dbLogin.setLoggedIn(true);
			
			// update isLoggedIn flag to true 
			loginRepo.save(dbLogin);
			LoginDto dto = new LoginDto();
			dto.setUsername(login.getUsername());
			dto.setRole(login.getRole());
			dto.setLoggedIn(true);
			
			return dto;
		} else {
			throw new InvalidCredentialsException("Invalid credentials");
		}
	}

	@Override
	public LoginDto logout(String Username) throws InvalidCredentialsException {
		logger.info(Username);
		Optional<Login> opt = loginRepo.findByUsrName(Username);
		if(!opt.isPresent()) {
			throw new InvalidCredentialsException("Invalid Credentials");
		}
		Login login= opt.get();
		logger.info(login.getUsername());
		login.setLoggedIn(false);
		loginRepo.save(login);
		LoginDto loginDto = new LoginDto();
		loginDto.setLoggedIn(false);
		return loginDto;
	}

}