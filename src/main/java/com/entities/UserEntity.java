package com.entities;




import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@SequenceGenerator(name = "usersequence",initialValue = 001)
@Table(name = "usersEntity")
public class UserEntity  {
	
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "usersequence")
	@Column(name = "id")
	private Long id;
	
	private String Role;
	
	@Pattern(regexp = "[a-zA-Z0-9]{3,}", message = "UserName should have atleast 3 characters")
	private String username;
	
	// password should not be null or empty
	// password should have minimum 4 characters
	@Pattern(regexp = "[a-zA-Z0-9@/!<>$#-_]{4,}", message = "password should have atleast 4 characters")
	private String password;
	
	
	@JsonIgnore
	private boolean isLoggedIn = false;
	
	public UserEntity() {
		super();
	}

	public UserEntity(
		
		@Pattern(regexp = "[a-zA-Z0-9]*", message = "Username should have atleast 8 characters") String username,
		@Pattern(regexp = "[a-zA-Z0-9@/!<>$#-_]*", message = "password should have atleast 4 characters") String password, String Role, Long id)
		{
		super();
		
		this.id = id;
		this.username = username;
		this.password = password;
		this.Role=Role;
	}

	public UserEntity(Long userId, String password2) {
		// TODO Auto-generated constructor stub
	}

	public String getRole() {
		return Role;
	}

	public void setRole(String role) {
		Role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
