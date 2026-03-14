package com.labs;

import java.util.Map;

public class Main {

    public static void main(String[] args) {

        EmployeeService service = new EmployeeService();

        // 1. Average Salary
        System.out.println("Solution 1 :");
        System.out.println("Average Salary: " + service.getAverageSalary());
        System.out.println();

        // 2. Max Salary Employee by Department
        System.out.print("Solution 2 :");
        System.out.println("\nMax Salary Employee in Each Department:");
        Map<String, Employee> maxEmp = service.getMaxSalaryEmployeeByDepartment();
        maxEmp.forEach((dept, emp) ->
                System.out.println(dept + " -> " + emp.getFirstName() + " : " + emp.getSalary())
        );
        System.out.println();

        // 3. Total Salary per Department
        System.out.print("Solution 3 :");
        System.out.println("\nTotal Salary by Department:");
        Map<String, Double> totalSalary = service.getTotalSalaryByDepartment();
        totalSalary.forEach((dept, total) ->
                System.out.println(dept + " -> " + total)
        );
        System.out.println();

        // 4. Display name and salary
        System.out.print("Solution 4 :");
        System.out.println("\nEmployee Name and Salary:");
        service.displayEmployeeNameAndSalary();
        System.out.println();

        // 5. Sort by Salary Desc
        System.out.print("Solution 5 :");
        System.out.println("\nEmployees Sorted by Salary (Descending):");
        service.getEmployeesSortedBySalaryDesc()
                .forEach(e ->
                        System.out.println(e.getFirstName() + " -> " + e.getSalary())
                );
    }
}
