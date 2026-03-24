package com.cg;

public class CalculatorMain {
public static void main(String[] args) {
	ICalculator c = (i,j)->i + j; //lambda function
	ICalculator c1 = (i,j)->i - j; //lambda function
	CalculatorService cService = new CalculatorService(c);
	CalculatorService cService1 = new CalculatorService(c1);
	
	System.out.println(cService1.addService(10, 5));
	System.out.println(cService.addService(10, 5));
}
}
