package com.dto;

import java.time.LocalDate;

import javax.persistence.Column;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDto {
	private Long id;
	
	private String name;

	private String password;
	
	private String email;
	
	private String contactNo;
	
	private LocalDate doB;
	private int loginId;
	
}