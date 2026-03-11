package com.cg.Entity;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "permanent-employee")
public class PEmployee extends Employee {
	//PEmployee = Permanent Employee
private double salary;

public double getSalary() {
	return salary;
}

public void setSalary(double salary) {
	this.salary = salary;
}

}
