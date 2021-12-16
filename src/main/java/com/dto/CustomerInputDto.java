package com.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class CustomerInputDto {

	private Long id;

	private String name;

	private String password;

	private String email;

	private String contactNo;

	private LocalDate doB;
}
