package com.example.EmployeeAuthService.Controller;

import com.example.EmployeeAuthService.Model.EmployeeModel;
import com.example.EmployeeAuthService.Model.LoginDTO;
import com.example.EmployeeAuthService.Model.UserResponse;
import com.example.EmployeeAuthService.Model.updatePasswordDto;
import com.example.EmployeeAuthService.Repository.EmployeeModelRepo;
import com.example.EmployeeAuthService.Service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class LoginController {

    @Autowired
    private EmployeeModelRepo repo;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private JwtService jwtService;
    @Autowired
    private AuthenticationManager manager;

    @PostMapping("/login")
    public String login(@RequestBody LoginDTO logDto) {
        Authentication auth = manager.authenticate(new UsernamePasswordAuthenticationToken(
                logDto.getUsername(), logDto.getPassword()));

        if (!auth.isAuthenticated()) {
            throw new AuthenticationCredentialsNotFoundException("Wrong Creds");
        }

        return jwtService.generateToken(logDto.getUsername());
    }


    @PutMapping("/updatePassword/{id}")
    public String updatePassword(@PathVariable int id, @RequestBody updatePasswordDto request) {
        EmployeeModel empMod = repo.findById(id).orElseThrow(() -> new UsernameNotFoundException("No User Found"));
        empMod.setPassword(encoder.encode(request.getPassword()));
        repo.save(empMod);

        return "Password Updated";

    }

    @GetMapping("/health")
    public String health() {

        return " : Health Wonderful";
    }

    @GetMapping("/getUser/{username}")
    public UserResponse getUser(@PathVariable String username)
    {
        UserResponse response = new UserResponse();
        EmployeeModel emp = repo.findByUsername(username) ;

        response.setEmpName(emp.getEmpName());
        response.setRole(emp.getRole().name());
        return response ;
    }

}
