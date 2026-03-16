package com.cg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.PropertySource;

import com.cg.bean.Employee;
import com.cg.bean.HelloWorld;

@SpringBootApplication
@PropertySource("classpath:data.properties")
//@ComponentScan("com") we can use it when our package is com.bean instead of com.cg.bean
public class FirstApplication {
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(FirstApplication.class, args);
		
		HelloWorld h = ctx.getBean(HelloWorld.class);
		System.out.println(h.sayHello("Mansi"));
		
		Employee emp = ctx.getBean(Employee.class);
		emp.printEmployeeDetails();

	}

}
