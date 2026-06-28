package com.example.EmployeeCreationService.Controller;

import com.example.EmployeeCreationService.Model.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "EMPLOYEE-AUTH-SERVICE")
public interface AuthFeignClient {

    @GetMapping("/auth/health")
    String getHealth();

    @GetMapping("/auth/getUser/{username}")
    UserResponse getUser(@PathVariable String username);


}

