package com.cg;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class CalServiceTest {
	private CalculatorService service;

	@BeforeEach
	public void init() {
//		service = new CalculatorService();
		
		ICalculator cal = Mockito.mock(ICalculator.class);
		service = new CalculatorService(cal);
		
		when(cal.calculate(20, 5)).thenReturn(25);
		when(cal.calculate(10, 5)).thenReturn(15); //Expectation
	}
	
	@Test
	void addServiceTest() {
//		assertEquals(25, service.addService(20, 5));
		assertEquals(15, service.addService(10, 5)); //Testing
	}

}

