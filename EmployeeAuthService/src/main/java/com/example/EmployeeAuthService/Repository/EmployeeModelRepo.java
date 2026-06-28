package com.example.EmployeeAuthService.Repository;

import com.example.EmployeeAuthService.Model.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeModelRepo extends JpaRepository<EmployeeModel ,Integer> {
    EmployeeModel findByUsername(String username);
}
