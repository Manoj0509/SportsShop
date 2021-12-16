package com.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.entities.UserEntity;
import com.exceptions.UserException;
import com.services.IUserService;

@RestController
@RequestMapping("/onlinesportshopee")
public class UserController {

	static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
//The @Autowired annotation provides more fine-grained control over where and how autowiring should be accomplished.
	@Autowired
	private IUserService iUserService;

	// for user mapping and crud operation.
	@PostMapping("/login/add-user")
	public ResponseEntity<UserEntity> addUser(@RequestBody UserEntity User) throws UserException {
		LOGGER.info("add-user URL is opened");
		LOGGER.info("addUserEntity() is initiated");
		UserEntity user = iUserService.addUser(User);
		LOGGER.info("addUser() has executed");
		return new ResponseEntity<UserEntity>(user, HttpStatus.ACCEPTED);
	}

	@GetMapping("/login/signin/{userId}/{password}")
	public ResponseEntity<UserEntity> signIn(@PathVariable("userId") Long userId,
			@PathVariable("password") String Password) throws UserException {
		LOGGER.info("signIn URL is opened");
		LOGGER.info("signIn() is initiated");
		UserEntity user1 = new UserEntity(userId, Password);
		UserEntity user = iUserService.signIn(user1);
		LOGGER.info("signIn() has Executed");
		return new ResponseEntity<UserEntity>(user, HttpStatus.ACCEPTED);
	}

	@GetMapping("/login/signout")
	public ResponseEntity<String> signOut() throws UserException {
		LOGGER.info("sign-out URL is opened");
		LOGGER.info("signout() is initiated");
		String signout = iUserService.signOut(null);
		LOGGER.info("signout() has Executed");
		return new ResponseEntity<String>(signout, HttpStatus.ACCEPTED);
	}

	@PutMapping("/login/changepassword/{userId}")
	public ResponseEntity<UserEntity> changePassword(@PathVariable Long userId, @RequestBody UserEntity User)
			throws UserException {
		LOGGER.info("changepassword URL is opened");
		LOGGER.info("changepassword() is initiated");
		UserEntity user = iUserService.changePassword(userId, User);
		LOGGER.info("changepassword() has Executed");
		return new ResponseEntity<UserEntity>(user, HttpStatus.ACCEPTED);
	}

}