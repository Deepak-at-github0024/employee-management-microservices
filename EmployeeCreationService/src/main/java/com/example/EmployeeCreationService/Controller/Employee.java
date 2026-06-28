package com.example.EmployeeCreationService.Controller;

import java.time.LocalDate;
import java.util.List;

class Employee {

    private  Long id;
    private String name;
    private String department;
    private Double salary;
    private Integer age;
    private LocalDate dob;
    private List<String> skills;

    private String city;
    private String gender;
    private LocalDate joiningDate;
    private Boolean active;
    private String designation;
    private Employee manager;          // Self reference
    private Integer experienceYears;

    public Employee() {

    }

    public Employee(Long id, String name, String department, Double salary, Integer age, LocalDate dob, List<String> skills, String city, String gender, LocalDate joiningDate, Boolean active, String designation, Employee manager, Integer experienceYears) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.age = age;
        this.dob = dob;
        this.skills = skills;
        this.city = city;
        this.gender = gender;
        this.joiningDate = joiningDate;
        this.active = active;
        this.designation = designation;
        this.manager = manager;
        this.experienceYears = experienceYears;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(LocalDate joiningDate) {
        this.joiningDate = joiningDate;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public Integer getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(Integer experienceYears) {
        this.experienceYears = experienceYears;


    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                ", dob=" + dob +
                ", skills=" + skills +
                ", city='" + city + '\'' +
                ", gender='" + gender + '\'' +
                ", joiningDate=" + joiningDate +
                ", active=" + active +
                ", designation='" + designation + '\'' +
                ", manager=" + manager +
                ", experienceYears=" + experienceYears +
                '}';
    }
}



