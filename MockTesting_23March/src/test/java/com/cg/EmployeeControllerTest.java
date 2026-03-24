package com.cg;

import com.cg.controller.EmployeeController;
import com.cg.dto.EmployeeDTO;
import com.cg.entity.Employee;
import com.cg.service.EmployeeService;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.http.MediaType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockitoBean
    private EmployeeService service;
    private ObjectMapper objectMapper = new ObjectMapper()
            .registerModule(new JavaTimeModule());

    @Test
    void TestgetEmployeeById() throws Exception {
        EmployeeDTO edto = new EmployeeDTO("Tushar", LocalDate.of(2002, 10, 11), 65461.00);
        when(service.getEmployee(1)).thenReturn(edto);
        mockMvc.perform(get("/api/employee/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.fullName")
                        .value("Tushar"));
    }

    @Test
    void getAllEmployeeTest() throws Exception{
        EmployeeDTO e1 = new EmployeeDTO("Samar", LocalDate.of(2002, 07, 13), 85000.00);
        EmployeeDTO e2 = new EmployeeDTO("Shreshtha", LocalDate.of(2003, 10, 14), 55000.00);
        EmployeeDTO e3 = new EmployeeDTO("Aarush", LocalDate.of(2004, 11, 15), 45000.00);

        when(service.getAllEmployee()).thenReturn(List.of(e1,e2,e3));

        mockMvc.perform(get("/api/employee"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[1].fullName").value("Shreshtha"));
    }

    @Test
    void testCreateEmployee() throws Exception {
        EmployeeDTO dto = new EmployeeDTO("Ravi", LocalDate.of(2000, 5, 20), 60000.00);

        when(service.createEmployee(any(EmployeeDTO.class))).thenReturn(dto);

        mockMvc.perform(post("/api/employee")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk()) 
                .andExpect(jsonPath("$.fullName").value("Ravi"));
    }

    @Test
    void testUpdateEmployee() throws Exception {
        Employee emp = new Employee("Manav", LocalDate.of(2001, 6, 15), 70000.00);

        when(service.updateEmployee(any(Employee.class))).thenReturn(emp);

        mockMvc.perform(put("/api/employee")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(emp)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Manav"));
    }

    @Test
    void testDeleteEmployee() throws Exception {
        when(service.removeEmployee(1)).thenReturn("Employee Deleted");

        mockMvc.perform(delete("/api/employee/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("Employee Deleted"));
    }
}