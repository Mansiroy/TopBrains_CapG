package com.cg.main;

import com.cg.bean.EmpServices;
import com.cg.bean.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class EmpMain {

	    public static void main(String[] args) {
	        ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
//	        EmployeeServices service = (EmployeeServices) ctx.getBean("es");
	//
	        EmpServices service = new EmpServices();
	        Scanner sc = new Scanner(System.in);

	        while (true){
	            System.out.println("ADD SBU       ----  1");
	            System.out.println("ADD EMPLOYEE  ----  2");
	            System.out.println("PROBLEM 1     ----  3");
	            System.out.println("PROBLEM 2     ----  4");
	            System.out.println("PROBLEM 3     ----  5");
	            System.out.println("PROBLEM 4     ----  6");
	            System.out.println("Exit          ----  10");
	            int choice = sc.nextInt();
	            sc.nextLine();

	            if (choice == 1){
	                service.addSBU();
	            }
	            else if(choice == 2){
	                service.addEmployee();
	            }
	            else if (choice == 3){
	                service.problem1();
	            }
	            else if (choice == 4){
	                service.problem2();
	            }
	            else if (choice == 5){
	                service.problem3();
	            }
	            else if(choice == 6){
	                service.problem4();
	            }
	            else if (choice == 10){
	                System.out.println("Thankyou");
	                break;
	            }
	        }
	    }
	}
