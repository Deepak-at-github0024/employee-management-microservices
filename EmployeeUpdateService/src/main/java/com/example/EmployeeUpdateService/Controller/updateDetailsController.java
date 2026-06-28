package com.example.EmployeeUpdateService.Controller;

import com.example.EmployeeUpdateService.Model.EmployeeModel;
import com.example.EmployeeUpdateService.Model.UsernameDTO;
import com.example.EmployeeUpdateService.Model.updatePasswordDto;
import com.example.EmployeeUpdateService.Repository.EmployeeModelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/update")
public class updateDetailsController {

    private FeignUpdateService feignClient ;

    public updateDetailsController(FeignUpdateService feignClient ) {
        this.feignClient = feignClient;
    }

    @Autowired
    private EmployeeModelRepo repo ;

    @PostMapping("/updateUsername/{id}")
    public String updateUsername(@PathVariable int id , @RequestBody UsernameDTO udt)
    {
        EmployeeModel employeeModel = repo.findById(id).orElseThrow(
                ()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"No User found for this ID"));
        employeeModel.setUsername(udt.getUsername());
        repo.save(employeeModel);
        return  "usernameUpdatedSuccessfully";
    }


    @PutMapping("/updatePassword/{id}")
    public String updatePassword(@RequestBody updatePasswordDto update)
    {
      feignClient.updatePassword(update);
      return "Password Updated from feign Auth Service" ;
    }
}
