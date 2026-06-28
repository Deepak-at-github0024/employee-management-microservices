package com.example.EmployeeUpdateService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EmployeeUpdateServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeUpdateServiceApplication.class, args);
	}

}
