package com.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.repository.IUserRepository;
import com.entities.UserEntity;

@SpringBootTest(classes = UserServiceImpl.class)
class UserServiceImplTest {
//used to add mocks 
	@MockBean
	IUserRepository iuserdao;

	@Autowired
	IUserService iuserservice;

	UserEntity user = null;
//used to signal that the annotated method is a test method. 
	@Test
	void testAddUser01() throws Exception {
		user = new UserEntity();
		user.setId((long) 1);
		user.setUsername("manoj");
		user.setPassword("manoj@123");
		//The Mockito library enables mock creation, verification and stubbing
		Mockito.when(iuserdao.saveAndFlush(user)).thenReturn(user);
		assertNotNull(user);
	}

	@Test
	void testSignInUser01() throws Exception {
		user = new UserEntity();
		user.setId((long) 1);
		user.setPassword("manoj@123");

		Mockito.when(iuserdao.save(user)).thenReturn(user);
		Assert.assertNotNull(user);
	}

	@Test
	void testChangePassword01() throws Exception {
		user = new UserEntity();
		user.setId((long) 8);
		user.setUsername("manoj");
		user.setPassword("manoj@123");
		user.setPassword("manoj@456");
		Mockito.when(iuserdao.save(user)).thenReturn(user);
	}
}
