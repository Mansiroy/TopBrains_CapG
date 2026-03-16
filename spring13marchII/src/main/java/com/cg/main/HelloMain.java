package com.cg.main;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cg.bean.Employee;
import com.cg.bean.HelloWorld;
import com.cg.cfg.MyConfig;

public class HelloMain {

	public static void main(String[] args) {
		ApplicationContext ctx=new AnnotationConfigApplicationContext(MyConfig.class);
//		BeanFactory ctx=new ClassPathXmlApplicationContext("bean.xml");
//		HelloWorld h=(HelloWorld)ctx.getBean("h");
//		HelloWorld h=ctx.getBean(HelloWorld.class);
//		HelloWorld h1=ctx.getBean(HelloWorld.class);
//		
//		System.out.println(h==h1);
//		System.out.println(h.sayHello());
		Employee e=ctx.getBean(Employee.class);
		e.printEmployeeDetails();

	}

}