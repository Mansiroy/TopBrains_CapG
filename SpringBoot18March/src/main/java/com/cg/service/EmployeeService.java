package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Employees;
import com.cg.repo.IEmployeeRepo;

@Service
public class EmployeeService {
	@Autowired
	private IEmployeeRepo repo;
	public String createEmployee(Employees emp) {
		repo.save(emp);
		Employees e = repo.saveAndFlush(emp);
//		return "\n Employee created successfully \n";
		return "Employee created successfully with: " + "ID: " + e.getEmpId();
		}
	
	public List<Employees> getAllEmployees(){
		return repo.findAll();
	}
	
	public Employees getEmployeesById(int empId) {
//		return repo.findById(empId).orElse(null);
		Optional<Employees> optionalEmp = repo.findById(empId);
		if(optionalEmp.isPresent()) {
			return optionalEmp.get();
		} else {
			return null;
		}
	}
	
	public String updateEmployee(Employees emp) {

	    Employees existing = repo.findById(emp.getEmpId()).orElse(null);

	    if (existing != null) {
	        existing.setEmpName(emp.getEmpName());
	        existing.setDob(emp.getDob());
	        existing.setSalary(emp.getSalary());

	        repo.save(existing);

	        return "Employee updated successfully";
	    } else {
	        return "Employee not found";
	    }
	}
	
	public  String removeEmployee(int empid){
        Employees emp=repo.findById(empid).orElseThrow(() -> new RuntimeException("Employee not found"));
        repo.deleteById(empid);
        return "Employee Deleted by Id: "+empid;
    }
}