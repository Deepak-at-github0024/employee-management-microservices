package com.example.EmployeeAuthService.Model;

import jakarta.persistence.*;

@Entity
public class EmployeeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String empName ;
    private String username;
    private String password ;
    @Enumerated(EnumType.STRING)
    private Role role ;

    public EmployeeModel() {
    }

    public EmployeeModel(Integer id, String empName, String userName, String password, Role role) {
        this.id = id;
        this.empName = empName;
        this.username = userName;
        this.password = password;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "EmployeeModel{" +
                "id='" + id + '\'' +
                ", empName='" + empName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
