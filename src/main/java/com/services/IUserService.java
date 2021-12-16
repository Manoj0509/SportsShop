package com.services;

import com.entities.UserEntity;
import com.exceptions.UserException;

public interface IUserService {

	public UserEntity addUser(UserEntity user) throws UserException;

	public UserEntity signIn(UserEntity user) throws UserException;

	public String signOut(UserEntity user);

	public UserEntity changePassword(Long id, UserEntity user) throws UserException;

}
