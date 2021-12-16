package com.entities;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;


@Data
@Entity
public class Login {

	@Id
	@GeneratedValue
	private int loginId;
	
	private String email;
     
	private String username;

	@NotEmpty(message = "Please enter your password")
	private String password;
	
	private String role;
	
	@JsonIgnore
	private boolean isLoggedIn = false;
	
	@JsonIgnore
	@OneToOne(mappedBy="login")
	private CustomerEntity customer;
		
}