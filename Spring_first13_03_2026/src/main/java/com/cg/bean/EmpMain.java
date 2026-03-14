//package com.cg.bean;
//
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import com.cg.bean.Address;
//import com.cg.bean.Employee;
//
//public class EmpMain {
//	public static void main(String[] args) {
////		Employee emp = new Employee();
////		 here we are accessing the properties of address class without creating the object of address class
////		emp.setAddress(new Address());
////		emp.printEmployeeDetails();
//			
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("beam.xml");
//		Employee emp = (Employee)ctx.getBean("e");
//		emp.printEmployeeDetails();
//		
//		((ClassPathXmlApplicationContext)ctx).close();
//	}
//}

package com.cg.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.cg.bean.Employee;

public class EmpMain {

    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("beam.xml");

        Employee emp = ctx.getBean(Employee.class);

        emp.display();
    }
}