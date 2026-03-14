//package com.cg.bean;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//
//public class Employee {
//	private int empid;
//	private String name;
//	@Autowired
//	@Qualifier("address")
//	private Address address;
//
//	public int getEmpid() {
//		return empid;
//	}
//
//	public void setEmpid(int empid) {
//		this.empid = empid;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public Address getAddress() {
//		return address;
//	}
//
//	public void setAddress(Address address) {
//		this.address = address;
//	}
//	
//	public void printEmployeeDetails() {
//		System.out.println("Employee Id :" +empid);
//		System.out.println("Employee name :" +name);
//		System.out.println("=================");
//		System.out.println("city:" +address.getCity());
//		System.out.println("country:" +address.getCountry());
//		System.out.println("zip:" +address.getZip());
//	}
//
//}

package com.cg.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Employee {

    @Value("${emp.id}")
    private int id;

    @Value("${emp.name}")
    private String name;

    @Value("${emp.salary}")
    private double salary;

    @Autowired
    private Address address;

    public void display() {
            System.out.println("==================Employee Details==============");
    	    System.out.println("Employee Id: " + id);
    	    System.out.println("Employee Name: " + name);
    	    System.out.println("Employee Salary: " + salary);
    	    System.out.println("==================Employee Address==============");
    	    System.out.println("Employee City: " + address.getCity());
    	    System.out.println("Employee Country: " + address.getCountry());
    	    System.out.println("Employee Zip: " + address.getZip());
    	    
    	}
    }
    
    

