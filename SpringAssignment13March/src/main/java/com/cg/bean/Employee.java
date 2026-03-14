package com.cg.bean;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("employee")
public class Employee {
    @Value("${empId}")
    private Integer empId;
    @Value("${empName}")
    private String empName;
    @Value("${salary}")
    private double salary;

    @Autowired
    @Qualifier("sbu")
    private SBU bu;

    @Value("${age}")
    private Integer age;



    public Employee(){}

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public SBU getBu() {
        return bu;
    }

    public void setBu(SBU bu) {
        this.bu = bu;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void PrintDetails(){
        System.out.println("Employee Id: "+this.empId);
        System.out.println("Employee Name: "+this.empName);
        System.out.println("Employee Salary: "+this.salary);
        System.out.println("Employee BU: "+this.bu.getSbuId());
        System.out.println("Employee Age: "+this.age);
    }

    public void problem2() {
        System.out.println("Employee Details");
        System.out.println(empId + " " + empName + " " + salary + " " + age);
        System.out.println(bu);
    }

    @Override
    public String toString() {
        return "Employee: "+"["+empId + ", " + empName + ", " + salary + ", " + age+"]";
    }
}
