package com.labs;

import java.util.Comparator;
//import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
//import java.util.Objects;
import java.util.stream.Collectors;

public class EmployeeService {

    private List<Employee> employees = EmployeeRepository.getEmployees();

    // 1. Calculate average salary
    public double getAverageSalary() {
        return employees.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0.0);
    }

    // 2. Find employee with maximum salary in each department
    public Map<String, Employee> getMaxSalaryEmployeeByDepartment() {
        return employees.stream()
                .filter(e -> e.getDepartment() != null)
                .collect(Collectors.groupingBy(
                        e -> e.getDepartment().getDepartmentName(),
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparing(Employee::getSalary)),
                                emp -> emp.orElse(null)
                        )
                ));
    }

    // 3. Calculate total salary per department
    public Map<String, Double> getTotalSalaryByDepartment() {
        return employees.stream()
                .filter(e -> e.getDepartment() != null)
                .collect(Collectors.groupingBy(
                        e -> e.getDepartment().getDepartmentName(),
                        Collectors.summingDouble(Employee::getSalary)
                ));
    }

    // 4. Display employee name and salary
    public void displayEmployeeNameAndSalary() {
        employees.stream()
                .forEach(e ->
                        System.out.println(e.getFirstName() + " : " + e.getSalary())
                );
    }

    // 5. Sort by salary in descending order
    public List<Employee> getEmployeesSortedBySalaryDesc() {
        return employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .collect(Collectors.toList());
    }
}