package day2;

import java.util.HashSet;
import java.util.Set;

public class SetDemo {
    public static void main(String[] args) {

       Set<Employee> s = new HashSet<Employee>();
       s.add(new Employee("Mansi"));
       s.add(new Employee("Samar"));
       s.add(new Employee("Shreshtha"));
       s.add(new Employee("Shreshtha"));
       System.out.println(s);       
//
//        s.add(new Employee("Samar"));
//        s.add(new Employee("Sam"));
//        s.add(new Employee("Samar"));
//        s.add(new Employee("Sam"));
//
//        System.out.println(s.size());
//    	
//    	Employee e = new Employee("MANSI");
//    	Employee e1 = new Employee("MANSI");
//    	System.out.println(e);
//    	System.out.println(e1);
//    	
//    	String s = new String("AAAA");
//    	System.out.println(e.equals(e1));
    }
}