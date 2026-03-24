package com.cg;

public class CalculatorService {
	private ICalculator cal; //interface refernece
	
//	public CalculatorService() {
//		super();
//	}

	public CalculatorService(ICalculator cal) { //injected interface
		super();
		this.cal = cal;
	}
	
	public int addService(int x, int y) {
		return cal.calculate(x, y);
	}

}
