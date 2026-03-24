package com.cg;

import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cg.entity.Employees;
import com.cg.repo.IEmployeeRepo;
import com.cg.service.EmployeeService;

@SpringBootApplication
public class SpringBoot18MarchApplication {

	public static void main(String[] args) {
		
		/*ApplicationContext ctx = SpringApplication.run(SpringDataApplication.class, args);

		IEmployeeRepo repo = ctx.getBean(IEmployeeRepo.class);

		repo.save(new Employees("Mansi", LocalDate.of(2002, 10, 4), 95000));
//		repo.save(new Employees("Samar", LocalDate.of(2002, 07, 13), 98000));

		System.out.println("Employee saved successfully");*/
		
		ApplicationContext ctx = SpringApplication.run(SpringBoot18MarchApplication.class, args);
		EmployeeService es = ctx.getBean(EmployeeService.class);
		
//		es.createEmployee(new Employees("Samar", LocalDate.of(2002, 07, 13), 98000));
		
		es.getAllEmployees().forEach(System.out::println);
//		
//		es.getAllEmployees().forEach(e -> System.out.println(e.getEmpId() + " " + e.getEmpName()));

		Employees emp = es.getEmployeesById(2);
		if(emp != null) {
			emp.setDob(LocalDate.of(2002, 06, 21));
			emp.setEmpName("Rishabh");
			System.out.println(es.updateEmployee(emp));
			
		}
		else {
			System.out.println("Employee not found");
		}

		es.getEmployeesById(2);
		
//		es.getAllEmployees().forEach(System.out::println);
		
//		es.removeEmployee(302);
		es.removeEmployee(402);
//		es.removeEmployee(352);
//		es.removeEmployee(353);
//		es.removeEmployee(253);
		es.getAllEmployees().forEach(System.out::println);
	}
}
