package com.example.EmployeeAuthService.Service;

import ch.qos.logback.core.joran.action.ActionUtil;
import com.example.EmployeeAuthService.Model.EmployeeModel;
import com.example.EmployeeAuthService.Model.MyUserDetails;
import com.example.EmployeeAuthService.Repository.EmployeeModelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private EmployeeModelRepo empRepo ;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        EmployeeModel empModel = empRepo.findByUsername(username);
        if(empModel == null)
        {
            throw new UsernameNotFoundException("No User Exists with the username");
        }

        return new MyUserDetails(empModel);

    }
}
