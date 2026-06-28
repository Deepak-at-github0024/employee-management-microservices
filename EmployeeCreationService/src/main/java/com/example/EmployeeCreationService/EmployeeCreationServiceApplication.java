package com.example.EmployeeCreationService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EmployeeCreationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeCreationServiceApplication.class, args);
	}

}
