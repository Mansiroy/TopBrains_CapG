package com.cg;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.cg.dao.IEmployeeRepo;
import com.cg.dto.EmployeeDTO;
import com.cg.dto.EntityMapper;
import com.cg.entity.Employee;
import com.cg.exception.EmployeNotFoundException;
import com.cg.service.EmployeeService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SpringRestDemoApplicationTests {

	@Mock
	private IEmployeeRepo repo;

	@InjectMocks
	private EmployeeService service;

	@Test
	void testEmployeeById() {
		EmployeeDTO edto = new EmployeeDTO("Mansi", LocalDate.of(2002, 3, 4), 83400.00);
		edto.setEmployeeId(1);

		Employee emp = EntityMapper.convertObjectToEntity(edto);

		when(repo.findById(1)).thenReturn(Optional.of(emp));

		EmployeeDTO result = service.getEmployee(1);

		assertNotNull(result);
		assertEquals("Mansi", result.getFullName());
	}

	@Test
	void testGetAllEmployee() {
		Employee employee = new Employee();
		employee.setEmpid(1);
		employee.setName("Mansi");

		List<Employee> list = Arrays.asList(employee);

		when(repo.findAll()).thenReturn(list);

		List<EmployeeDTO> result = service.getAllEmployee();

		assertEquals(1, result.size());
		verify(repo, times(1)).findAll();
	}

	@Test
	void testEmployeeByIdWithException() {

		when(repo.findById(2)).thenReturn(Optional.empty());

		assertThrows(EmployeNotFoundException.class, () -> {
			service.getEmployee(2);
		});
	}

	@Test
	void testRemoveEmployee() {

		// Create object here (instead of @BeforeEach)
		Employee employee = new Employee();
		employee.setEmpid(1);
		employee.setName("Mansi");

		// Case 1: Employee exists
		when(repo.findById(1)).thenReturn(Optional.of(employee));

		String result1 = service.removeEmployee(1);
		assertEquals("Employee Deleted", result1);

		verify(repo, times(1)).deleteById(1);

		// Reset mock
		reset(repo);

		// Case 2: Employee not found
		when(repo.findById(2)).thenReturn(Optional.empty());

		assertThrows(EmployeNotFoundException.class, () -> {
			service.removeEmployee(2);
		});

		verify(repo, never()).deleteById(anyInt());
	}

	@Test
	void testUpdateEmployee_success() {

		// create object
		Employee employee = new Employee();
		employee.setEmpid(1);
		employee.setName("Mansi");

		// mock findById (used in getEmployee)
		when(repo.findById(1)).thenReturn(Optional.of(employee));

		// mock save
		when(repo.saveAndFlush(any(Employee.class))).thenReturn(employee);

		// call method
		Employee result = service.updateEmployee(employee);

		// assertions
		assertNotNull(result);
		assertEquals("Mansi", result.getName());

		// verify
		verify(repo, times(1)).saveAndFlush(any(Employee.class));
	}

	@Test
	void testGetEmployeeByName() {

		// create object
		Employee employee = new Employee();
		employee.setEmpid(1);
		employee.setName("Mansi");

		// mock repo
		when(repo.findByName("Mansi")).thenReturn(Arrays.asList(employee));

		// call method
		List<EmployeeDTO> result = service.getEmployeeByName("Mansi");

		// assertions
		assertNotNull(result);
		assertEquals(1, result.size());
		assertEquals("Mansi", result.get(0).getFullName());

		// verify
		verify(repo, times(1)).findByName("Mansi");
	}

	@Test
	void testCreateEmployee() {

		EmployeeDTO dto = new EmployeeDTO();
		dto.setEmployeeId(11);
		dto.setFullName("Mansi Roy");
		dto.setDateOfBirth(LocalDate.of(2002, 04, 10));
		dto.setSalary(20000.00);

		Employee employee = new Employee();
		employee.setEmpid(11);
		employee.setName("Mansi Roy");
		employee.setDob(LocalDate.of(2002, 04, 10));
		employee.setSalary(20000.00);

		when(repo.saveAndFlush(any(Employee.class))).thenReturn(employee);

		EmployeeDTO result = service.createEmployee(dto);

		assertNotNull(result);
		assertEquals("Mansi Roy", result.getFullName());

		verify(repo, times(1)).saveAndFlush(any(Employee.class));
	}

//    @Test
//    void testCreateEmployee() {
//    	EmployeeDTO edto = new EmployeeDTO("Mansi", LocalDate.of(2002, 10, 04), 95000);
//    	
//    	Employee emp = new Employee("Mansi", LocalDate.of(2002, 10, 04), 95000);
//    	emp.setEmpid(1);
//    	
//    	when(repo.saveAndFlush(any(Employee.class))).thenReturn(emp);
//    	
//    	EmployeeDTO result = service.createEmployee(edto);
//
//        assertNotNull(result);
//        assertEquals("Mansi", result.getFullName());
////      assertEquals("Mansi", service.createEmployee(edto).getFullName());
//
//        verify(repo, times(1)).saveAndFlush(any(Employee.class));
//    }   
//    

}