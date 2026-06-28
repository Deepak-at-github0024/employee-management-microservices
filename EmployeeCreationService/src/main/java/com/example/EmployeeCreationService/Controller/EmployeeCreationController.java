package com.example.EmployeeCreationService.Controller;

import com.example.EmployeeCreationService.Model.EmployeeModel;
import com.example.EmployeeCreationService.Model.UserResponse;
import com.example.EmployeeCreationService.Repository.EmployeeModelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeCreationController {

    private final AuthFeignClient authFeignClient ;

    public EmployeeCreationController(AuthFeignClient authFeignClient) {
        this.authFeignClient = authFeignClient;
    }

    @Autowired
    private EmployeeModelRepo repo ;

    @Autowired
    private PasswordEncoder encoder ;

    @PostMapping("/createEmployee")
    public String createEmployee(@RequestBody EmployeeModel employeeModel)
    {
        employeeModel.setPassword(encoder.encode(employeeModel.getPassword()));
        repo.save(employeeModel);
        return  "Employee Created";
    }

    @GetMapping("/test-feign")
    public String testFeign()
    {
        String response = authFeignClient.getHealth() ;

        return "Response From AuthService"+response ;
    }

    @GetMapping("/getFinUser/{username}")
    public UserResponse getUserInfo(@PathVariable String username)
    {
        return authFeignClient.getUser(username);
    }

}

