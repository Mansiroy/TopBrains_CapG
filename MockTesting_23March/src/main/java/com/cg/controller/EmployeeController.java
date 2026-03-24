package com.cg.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.dto.EmployeeDTO;
import com.cg.entity.Employee;
import com.cg.service.IEmployeeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("api/employee")
public class EmployeeController {
	//@Autowired
	private IEmployeeService service;	

	public EmployeeController(IEmployeeService service) {
		super();
		this.service = service;
	}
	
	@PostMapping(consumes = {"application/json","application/xml"})
	public EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO emp) {
		return service.createEmployee(emp);
	}

	@GetMapping(produces = {"application/json","application/xml"})
	@Operation(summary = "This API will provide all the employee details from MySQL")
	@Tag(name="EmployeeAPI",description="This is the CERUD operations Employee Entity")
	public List<EmployeeDTO> getAll() {
		return service.getAllEmployee();
	}
	@GetMapping("/{eid}")
	public ResponseEntity<EmployeeDTO> getEmp(@PathVariable int eid) {
		return new ResponseEntity<EmployeeDTO>(service.getEmployee(eid),HttpStatus.OK);
		
	}
	@GetMapping("/name/{name}")
	public List<EmployeeDTO> getEmpByName(@PathVariable String name) {
		return service.getEmployeeByName(name);
	}
	
	
	@DeleteMapping("/{eid}")
	public String delEmp(@PathVariable int eid) {
		return service.removeEmployee(eid);
	}
	
	@PutMapping
	public Employee updateEmployee(@RequestBody Employee emp) {
		return service.updateEmployee(emp);
	}
	
}
