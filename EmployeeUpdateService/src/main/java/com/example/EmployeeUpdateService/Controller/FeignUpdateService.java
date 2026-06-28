package com.example.EmployeeUpdateService.Controller;

import com.example.EmployeeUpdateService.Model.updatePasswordDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@FeignClient(name = "EMPLOYEE-AUTH-SERVICE")
public interface FeignUpdateService {

@PutMapping("/auth/updatePassword/{id}")
String updatePassword(@RequestBody updatePasswordDto updatePasswordDto) ;


}
