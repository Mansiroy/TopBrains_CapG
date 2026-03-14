package com.cg.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.*;

//@Component("es")
public class EmpServices {
	
	    ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
	    private Map<Integer,Employee> employeeList = new HashMap<>();
	    private Map<String, SBU> sbuList = new HashMap<>();
	    
	    Scanner sc = new Scanner(System.in);
	    public void addEmployee(){
	        Employee emp = (Employee) ctx.getBean("employee");
	        System.out.println("Enter id: ");
	        Integer empId = sc.nextInt();
	        sc.nextLine();
	        System.out.println("Enter Name: ");
	        String empName = sc.nextLine();
	        System.out.println("Enter Salary: ");
	        Double sal = sc.nextDouble();
	        sc.nextLine();
	        System.out.println("Enter Age: ");
	        Integer age = sc.nextInt();
	        sc.nextLine();
	        System.out.println("Enter BU id: ");
	        String buId = sc.nextLine();
	        SBU bu = null;

	        if (sbuList.containsKey(buId)){
	            bu = sbuList.get(buId);
	        }
	        else{
	            System.out.println("NO BU ID PRESENT");
	            System.out.println("ADD SBU DETAILS FIRST");
	            return;
	        }
	        emp.setEmpName(empName);
	        emp.setBu(bu);
	        emp.setAge(age);
	        emp.setEmpId(empId);
	        emp.setSalary(sal);

	        employeeList.put(empId,emp);

	    }

	    public void addSBU(){
	        System.out.println("Enter SBU ID: ");
	        String bu_id = sc.nextLine();
	        System.out.println("Enter SBU Name: ");
	        String name = sc.nextLine();
	        System.out.println("Enter SBU Head: ");
	        String head = sc.nextLine();

	        if (sbuList.containsKey(bu_id)){
	            System.out.println("Already SBU Present");
	        }
	        else{
	            SBU bu = (SBU) ctx.getBean("sbu");
	            bu.setSbuId(bu_id);
	            bu.setSbuHead(head);
	            bu.setSbuName(name);
	            sbuList.put(bu_id,bu);
	        }
	    }

	    public void problem1(){
	        System.out.println("Enter Employee Id: ");
	        int id = sc.nextInt();
	        sc.nextLine();
	        Employee emp = findEmployee(id);
	        if (emp != null) {
	            System.out.println("Employee Id: " + emp.getEmpId());
	            System.out.println("Employee Name: " + emp.getEmpName());
	            System.out.println("Employee Salary: " + emp.getSalary());
	            System.out.println("Employee BU: " + emp.getBu().getSbuId());
	            System.out.println("Employee Age: " + emp.getAge());
	        }
	        else{
	            System.out.println("No Employee Found");
	        }
	    }

	    public void problem2() {
	        System.out.println("Enter Employee Id: ");
	        int id = sc.nextInt();
	        sc.nextLine();
	        Employee emp = findEmployee(id);
	        if (emp!=null) {
	            System.out.println("Employee Details");
	            System.out.println(emp.getEmpId() + " " + emp.getEmpName() + " " + emp.getSalary() + " " + emp.getAge());
	            System.out.println(emp.getBu());
	        }
	        else{
	            System.out.println("No Employee found");
	        }
	    }

	    public void problem3(){
	        System.out.println("Enter SBU id: ");
	        String id = sc.nextLine();
	        SBU bu = findSBU(id);
	        if (bu != null) {
	            System.out.println(bu);
	            System.out.println(bu.getEmployeeList());
	        }
	        else{
	            System.out.println("No Record Found");
	        }
	    }

	    public void problem4(){
	        System.out.println("Enter Employee Id: ");
	        int id = sc.nextInt();
	        sc.nextLine();
	        Employee emp = findEmployee(id);
	        if (emp != null){
	            System.out.println(id);
	            System.out.println(emp.getEmpName());
	            System.out.println(emp.getAge());
	            System.out.println(emp.getSalary());
	        }
	        else{
	            System.out.println("No Employee with this Id");
	        }
	    }
	    public Employee findEmployee(int id){
	        if (employeeList.containsKey(id)){
	            return employeeList.get(id);
	        }
	        else{
	            return null;
	        }

	    }

	    public SBU findSBU(String id){
	        if (sbuList.containsKey(id)){
	            return sbuList.get(id);
	        }
	        else{
	            return null;
	        }
	    }
	}


