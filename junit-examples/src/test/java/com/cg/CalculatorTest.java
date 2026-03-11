package com.cg;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertFalse;
import  org.junit.jupiter.api.Timeout;

public class CalculatorTest {
	static Calculator cal;
//	@BeforeEach
//	public void init() {
//		cal = new Calculator();
//		System.out.println("Calculator object created");
//	}
//	
//	@AfterEach
//	public void destroy() {
//		cal = null;
//		System.out.println("Calculator object destroyed");
//	}
	
	@BeforeAll
	public static void init() {
		cal = new Calculator();
		System.out.println("Calculator object created");
	}

	@AfterAll
	public static void destroy() {
		cal = null;
		System.out.println("Calculator object destroyed");
	}
	
	@Test
	@DisplayName(value = "Testing Calculate Value")
	@ParameterizedTest
	@CscSource({"2, 4, 6", "6, 5, 11", "10, 15, 25"})
	public void calTest() {
		//Calculator cal = new Calculator();
		System.out.println("Testing Calculate Method");
		assertEquals(10, cal.calculate(7,  3));
	}
	
	@Test
//	@Timeout(2)   // 2 is milisecond
	@Timeout(value = 1000000, unit =TimeUnit.NANOSECONDS)
	//@Disabled
	@ParameterizedTest
	
	public void isPrimeTest() {
		System.out.println("Testing isPrime Method");

		assertTrue(cal.isPrime(13));
		assertFalse(cal.isPrime(0));
		
	}
}
