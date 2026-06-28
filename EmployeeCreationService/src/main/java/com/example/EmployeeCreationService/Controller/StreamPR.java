package com.example.EmployeeCreationService.Controller;


import java.security.KeyStore;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class StreamPR {
    public static void main(String ar[]) {
 /*      List<Employee> employees = List.of(new Employee(
                        101L,
                        "John",
                        "IT",
                        85000.0,
                        28,
                        LocalDate.of(1997, 5, 10),
                        List.of("Java", "Spring Boot", "SQL")
                ),

                new Employee(
                        102L,
                        "David",
                        "IT",
                        95000.0,
                        32,
                        LocalDate.of(1993, 3, 15),
                        List.of("Java", "Microservices", "Kafka")
                ),

                new Employee(
                        103L,
                        "John",
                        "HR",
                        65000.0,
                        29,
                        LocalDate.of(1996, 8, 20),
                        List.of("Excel", "Recruitment", "Communication")
                ),

                new Employee(
                        104L,
                        "Mary",
                        "Finance",
                        95000.0,
                        35,
                        LocalDate.of(1990, 11, 25),
                        List.of("Accounting", "Excel", "Taxation")
                ),

                new Employee(
                        105L,
                        "Alex",
                        "IT",
                        75000.0,
                        26,
                        LocalDate.of(1999, 1, 5),
                        List.of("Java", "AWS", "Docker")
                ));


       List<String> names = employees.stream()
               .filter(f->f.getSalary() > 50000)
               .map(Employee::getName).toList();




     Double totalSal = employees.stream().map(Employee::getSalary)
             .reduce(0D, Double::sum);

     int count = Math.toIntExact(employees.stream().filter(emp -> emp.getDepartment().equals("IT")).count());

     boolean empName = employees.stream().anyMatch(e->e.getSalary() > 200000);


     boolean allIndian = employees.stream().allMatch(e->e.getDepartment().equals("IT"));

        Map<String,List<String>> grouped = employees.stream()
                        .collect(
                                Collectors.groupingBy(Employee::getDepartment ,
                                        Collectors.mapping(Employee::getName , Collectors.toList()))
                        ) ;

        Map<String,Long> countByDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment , Collectors.counting()));

        Map<String,List<Employee>> modelByDept = employees.stream()
                        .collect(Collectors.groupingBy(Employee::getDepartment));

        Map<String,List<List<String>>> skillsByDept = employees.stream()
                        .collect(Collectors.groupingBy(Employee::getDepartment ,
                                Collectors.mapping(e->e.getSkills(), Collectors.toList())));

        /*skillsByDept
                .forEach((department , skills)->{
                    System.out.println(department+"->"+skills);

                });

        Map<String, Set<String>> skillbyDept =
                employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,
                Collectors.flatMapping(e->e.getSkills().stream() , Collectors.toSet()))) ;


        DoubleSummaryStatistics stas =
                employees.stream().collect(Collectors.summarizingDouble(Employee::getSalary));


        Map<String,Double> salByDept = employees.stream().collect(
                Collectors.groupingBy(Employee::getDepartment , Collectors.summingDouble(e->e.getSalary())));

        Map<String,Double> avgByDept = employees.stream().collect(
                Collectors.groupingBy(Employee::getDepartment , Collectors.averagingDouble(e->e.getSalary())));


        Optional<Employee> emp = employees.stream().max(Comparator.comparing(Employee::getSalary));

        Optional<Employee> youngestEmp = employees.stream().min(Comparator.comparing(Employee::getAge));


        Map<String, Optional<Employee>> highestpaidEMp = employees.stream()
                        .collect(Collectors.groupingBy(Employee::getDepartment ,
                                Collectors.maxBy(Comparator.comparing(Employee::getSalary))));

        Map<String, String> highestPaidEmpName = employees.stream()
                        .collect(Collectors.groupingBy(Employee::getDepartment , Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparing(Employee::getSalary)) ,
                                em->em.map(Employee::getName).orElse("?")
                        ))) ;

        String oldestEmpName = employees.stream()
                        .collect(Collectors.collectingAndThen(Collectors.maxBy(
                                Comparator.comparing(Employee::getAge)) ,
                                em->em.map(Employee::getName).orElse("?")));


        Map<String, Optional<Employee>> oldestByDept = employees.stream()
                        .collect(Collectors.groupingBy(Employee::getDepartment ,
                                Collectors.maxBy(Comparator.comparing(Employee::getAge)))) ;

        Map<String , String> oldesEmpNameByDept = employees.stream()
                        .collect(Collectors.groupingBy(Employee::getDepartment ,
                                Collectors.collectingAndThen(Collectors.maxBy(
                                        Comparator.comparing(Employee::getAge)),
                                        e->e.map(Employee::getName).orElse("?"))));


        Map<String , Map<Integer ,List<Employee>>> empByMyDeptBy;

        Map<String,Optional<Employee>>HighestPaidEmpinDept = employees.stream()
                        .collect(Collectors.groupingBy(Employee::getDepartment ,
                                Collectors.maxBy(Comparator.comparing(Employee::getSalary))));

        Map<String , Map<Integer , List<Employee>>> groupByDeptByAge =
                employees.stream().collect(Collectors.groupingBy(Employee::getDepartment ,
                        Collectors.groupingBy(Employee::getAge))) ;


        Map<String , String> highEmp =
                employees.stream()
                                .collect(Collectors.groupingBy(Employee::getDepartment ,
                                        Collectors.collectingAndThen(Collectors
                                                .maxBy(Comparator.comparing(Employee::getSalary)),
                                                e->e.map(Employee::getName).orElse("?"))));


        Map<String,Double>HighestSalAmtByDept = employees.stream()
                        .collect(Collectors.groupingBy(Employee::getDepartment,
                                Collectors.collectingAndThen(Collectors
                                        .maxBy(Comparator.comparing(Employee::getSalary)) ,
                                        e->e.map(Employee::getSalary).orElse(0D))));

        Set<String>allUniguieSkills = employees.stream().flatMap(
                e->e.getSkills().stream()).collect(Collectors.toSet());


        Map<String,Long> occurence =
                employees.stream()
                                .flatMap(s->s.getSkills().stream())
                        .collect(Collectors.groupingBy(s->s , Collectors.counting()));


        Optional<Map.Entry<String, Long>> occu = occurence.entrySet().stream()
                        .max((Comparator.comparing(Map.Entry::getValue)));

        String skils = occurence.entrySet().stream()
                .max(Map.Entry.comparingByValue()).map(e->e.getKey()).orElse("?");

        Map<String,Long>nameOcc = employees.stream()
                .collect(Collectors.groupingBy(Employee::getName , Collectors.counting()));

        List<String> dupName =  nameOcc.entrySet().stream()
                        .filter(e->e.getValue() > 1)
                                .map(Map.Entry::getKey).toList();


        List<String> top3Sal =  employees.stream().sorted(Comparator
                .comparing(Employee::getSalary).reversed()).limit(3).map(Employee::getName).toList();



        Set<String>  ski = employees.stream().flatMap(s->s.getSkills().stream()).collect(Collectors.toSet());

        double secondSalary = employees.stream().collect(Comparator.comparing(Employee::getSalary)) ;


        System.out.println(top3Sal);    */


    }
}

