package com.cg.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cg.bean.HelloWorld;

public class Main {
	public static void main(String[] args) {
		//HelloWorld h = new HelloWorld();
		//I want to create a object by IOC
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
		HelloWorld h1 = (HelloWorld)ctx.getBean("hello");
//		HelloWorld h2= (HelloWorld)ctx.getBean("hello");
		
		//src folder is a classpath
		//System.out.println(h.sayHello("Mansi"));
		
//		System.out.println(h1 == h2); // it gives us true or false value.
		
//		h1.setName("Mansi");
//		h2.setName("Roy Sahab");
		
		System.out.println(h1.sayHello());
		System.out.println("==============");
		System.out.println(h1.getLanguage());
//		System.out.println(h2.sayHello());		
		
		((ClassPathXmlApplicationContext)ctx).close();
	}
}
