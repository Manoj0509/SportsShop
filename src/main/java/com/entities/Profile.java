package com.entities;


import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Profile {

	@Id
	@GeneratedValue
	private int profileId;	
	private LocalDate dob;
	
	@JsonIgnore
	@OneToOne(mappedBy="profile", cascade= {CascadeType.PERSIST, CascadeType.REFRESH})
	CustomerEntity scustomer;
}