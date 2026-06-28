package com.example.EmployeeCreationService.Controller;

import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamPractice {

    public static void main (String ar[])
    {
        List<Employee> empList = List.of(new Employee(
                        1L,
                        "Rahul",
                        "IT",
                        85000.0,
                        28,
                        LocalDate.of(1997, 5, 10),
                        List.of("Java", "Spring Boot", "SQL"),
                        "Kolkata",
                        "Male",
                        LocalDate.of(2021, 6, 15),
                        true,
                        "Developer",
                        null,
                        4
                ),

                new Employee(
                        2L,
                        "Priya",
                        "HR",
                        60000.0,
                        30,
                        LocalDate.of(1995, 8, 20),
                        List.of("Recruitment", "Excel"),
                        "Mumbai",
                        "Female",
                        LocalDate.of(2020, 3, 10),
                        true,
                        "HR Executive",
                        null,
                        6
                ),

                new Employee(
                        3L,
                        "Amit",
                        "IT",
                        95000.0,
                        32,
                        LocalDate.of(1993, 2, 14),
                        List.of("Java", "Microservices", "AWS"),
                        "Bangalore",
                        "Male",
                        LocalDate.of(2018, 7, 1),
                        true,
                        "Senior Developer",
                        null,
                        8
                ),

                new Employee(
                        4L,
                        "Sneha",
                        "Finance",
                        70000.0,
                        29,
                        LocalDate.of(1996, 9, 5),
                        List.of("Excel", "Taxation"),
                        "Delhi",
                        "Female",
                        LocalDate.of(2022, 1, 5),
                        true,
                        "Analyst",
                        null,
                        5
                ),

                new Employee(
                        5L,
                        "Vikram",
                        "IT",
                        120000.0,
                        35,
                        LocalDate.of(1990, 11, 11),
                        List.of("Java", "Spring Boot", "Kafka"),
                        "Hyderabad",
                        "Male",
                        LocalDate.of(2016, 5, 20),
                        true,
                        "Tech Lead",
                        null,
                        12
                ),

                new Employee(
                        6L,
                        "Neha",
                        "Finance",
                        75000.0,
                        31,
                        LocalDate.of(1994, 4, 17),
                        List.of("Accounting", "Excel", "SQL"),
                        "Pune",
                        "Female",
                        LocalDate.of(2019, 8, 12),
                        false,
                        "Senior Analyst",
                        null,
                        7
                ),

                new Employee(
                        7L,
                        "Rahul",
                        "Operations",
                        65000.0,
                        27,
                        LocalDate.of(1998, 1, 25),
                        List.of("Reporting", "Excel"),
                        "Kolkata",
                        "Male",
                        LocalDate.of(2023, 2, 1),
                        true,
                        "Operations Executive",
                        null,
                        3
                ),

                new Employee(
                        8L,
                        "Anjali",
                        "IT",
                        105000.0,
                        33,
                        LocalDate.of(1992, 7, 8),
                        List.of("Java", "Spring Boot", "Docker", "Kubernetes"),
                        "Bangalore",
                        "Female",
                        LocalDate.of(2017, 11, 15),
                        true,
                        "Architect",
                        null,
                        10
                ),

                new Employee(
                        9L,
                        "Rohit",
                        "Sales",
                        55000.0,
                        26,
                        LocalDate.of(1999, 3, 3),
                        List.of("Negotiation", "CRM"),
                        "Mumbai",
                        "Male",
                        LocalDate.of(2024, 1, 10),
                        true,
                        "Sales Executive",
                        null,
                        2
                ),

                new Employee(
                        10L,
                        "Pooja",
                        "IT",
                        90000.0,
                        30,
                        LocalDate.of(1995, 12, 19),
                        List.of("Java", "Spring Boot", "SQL", "Kafka"),
                        "Chennai",
                        "Female",
                        LocalDate.of(2020, 9, 21),
                        true,
                        "Developer",
                        null,
                        6
                )) ;

        List<Employee> getAllEmployee = empList.stream().toList();

        List<String> getAllEmpNames = empList.stream().map(Employee->Employee.getName()).toList();
       // getAllEmployee.forEach(System.out::println);

      List<String>allDepts = empList.stream().map(Employee::getDepartment).toList();

        Map<String,Long> deptOccurence = empList.stream().collect(Collectors.groupingBy(Employee::getDepartment , Collectors.counting()));


       long count = empList.stream().count();


       Optional<Employee> emp = empList.stream().filter(s->s.getId().equals(9L)).findFirst();


       List<Employee> sortedEmp = empList.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).toList() ;

       //empList.stream().sorted(Comparator.comparing(Employee::getDepartment).thenComparing(Employee::getSalary)).forEach(System.out::println);

        Double totalSal = empList.stream().mapToDouble(s->s.getSalary()).sum();

        Map<String,Double>totalSalByDept = empList.stream().collect(Collectors.groupingBy(Employee::getDepartment , Collectors.summingDouble(Employee::getSalary)));
        Map<String,Double>averageByDept = empList.stream().collect(Collectors.groupingBy(Employee::getDepartment , Collectors.averagingDouble(Employee::getSalary)));
        Map<String, Optional<Employee>>highestByDept = empList.stream().collect(Collectors.groupingBy(Employee::getDepartment ,
            Collectors.maxBy(Comparator.comparing(Employee::getSalary))))/*.forEach((dept,sal)->System.out.println(dept+"--->>>"+sal))*/;

        Double avgSal = empList.stream().mapToDouble(Employee::getSalary).average().orElse(0D);
        OptionalDouble avgSal2 = empList.stream().mapToDouble(Employee::getSalary).average();

        Double highestSal = empList.stream().mapToDouble(Employee::getSalary).max().orElse(0D);

        Map<String,Double> highestSalByDept = empList.stream().collect(Collectors.groupingBy(Employee::getDepartment ,
                Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Employee::getSalary)) , s->s.map(Employee::getSalary).orElse(0D))));

        Double lowestSal = empList.stream().min(Comparator.comparing(Employee::getSalary)).map(Employee::getSalary).orElse(0D);

        Double lowestSal2 = empList.stream().mapToDouble(Employee::getSalary).min().orElse(0D);


        Map<String,Long> emnpByDept = empList.stream().collect(Collectors.groupingBy(Employee::getDepartment , Collectors.counting()));

        List<String> uniqSkills = empList.stream().flatMap(e->e.getSkills().stream()).distinct().toList();

        Map<String,Long> occOfSkills = empList.stream().flatMap(e->e.getSkills().stream()).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

        Optional<Map.Entry<String ,Long>> skill = occOfSkills.entrySet().stream().max(Map.Entry.comparingByValue());

        /*List<Employee> javaSkilledEmp =*/ //empList.stream().filter(s->s.getSkills().contains("Java")).forEach(System.out::println); ;


        //List<Employee>empNameStartWithV = empList.stream().filter(e->).toList();

        empList.stream()
                .min(
                        Comparator.comparing(
                                Employee::getSalary
                        )
                );


       System.out.println(skill);


















    }
}
