package day2;

import java.util.Objects;

public class Employee {
	private String name;
	public Employee(String name){
		this.name = name;
	}
	
	public int hashCode() {
		System.out.println("#######");
		return name.length();
	}

	public boolean equals(Object obj) {
   System.out.println("======");
		if(obj instanceof Employee && this.name == ((Employee)obj).name)
		return true;
		else
			return false;
	}
	
	public String toString() {
		return name;
	}
	

}