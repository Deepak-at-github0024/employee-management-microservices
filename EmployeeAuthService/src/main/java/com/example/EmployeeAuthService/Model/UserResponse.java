package com.example.EmployeeAuthService.Model;

public class UserResponse {

   private String empName;
   private String role ;

    public UserResponse() {
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
