package com.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controller.UserController;
import com.entities.UserEntity;
import com.exceptions.UserException;
import com.repository.IUserRepository;

@Service
public class UserServiceImpl implements IUserService {

	static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private IUserRepository Userrepo;

	@Override
	public UserEntity addUser(UserEntity user) throws UserException {
		LOGGER.info("addUser() service is initiated");
		UserEntity userEnti;
		if (user.getUsername() == "" || user.getPassword() == null)
			throw new UserException("Username or password cannot be empty");
		else {
			userEnti = Userrepo.save(user);
		}
		LOGGER.info("addUser() service has executed");
		return userEnti;
	}

	@Override
	public UserEntity signIn(UserEntity user) throws UserException {
		LOGGER.info("signin() service is initiated");
		UserEntity useridrepo = Userrepo.findById(user.getId()).orElse(null);
		if (useridrepo == null) {
			String usernotfound = "No user found by the userid " + user.getId();
			throw new UserException(usernotfound);
		} else {
			if (user.getId().equals(useridrepo.getId()) && user.getPassword().equals(useridrepo.getPassword())) {
				LOGGER.info("signin() service has Executed");
				return useridrepo;
			} else {
				throw new UserException("User name and password are invalid");
			}
		}
	}

	@Override
	public String signOut(UserEntity user) {
		LOGGER.info("signout() service is initiated");
		return "Signout Successfully";
	}

	@Override
	public UserEntity changePassword(Long id, UserEntity user) throws UserException {
		LOGGER.info("changepassword() service is initiated");
		if (id == 0 || user.getPassword() == null)
			throw new UserException("Userid or password cannot be empty");
		UserEntity userEnti;
		UserEntity changePassword = Userrepo.findById(id).orElse(null);
		if (changePassword == null) {
			String usernotfound = "No user found by the userid ";
			throw new UserException(usernotfound);
		} else
			userEnti = Userrepo.save(user);
		LOGGER.info("changepassword() service has Executed");
		return userEnti;
	}
}