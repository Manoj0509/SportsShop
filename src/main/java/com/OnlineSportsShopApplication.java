package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class OnlineSportsShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineSportsShopApplication.class, args);
		System.out.println("Connected to database");
	}

	// http://localhost:8088/swagger-ui/index.html#/

}
