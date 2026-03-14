package com.cg.bean;

//import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCar {
	public static void main(String[] args) {
//	Car honda = new Car(new PetrolEngine(), new MrfTyre());
//	honda.setName("Elevate");
//	honda.printCar();

		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
		Car c = (Car) ctx.getBean("car");
		
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter Engine type (petrol of CNG)");
//		String etype = sc.next();
//		System.out.println("Enter Tyre Choice (mrf or jk)");
//		String tyre = sc.next();
//		
//		IEngine e = (IEngine)ctx.getBean(etype.toLowerCase());
//		ITyre t = (ITyre)ctx.getBean(tyre);
//		c.setCNG(e);
//		c.setMRF(t);
		
//		c.setName("Alto");
		c.printCar();
	}
}
