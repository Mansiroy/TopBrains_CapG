package com;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;

/**
 * @author 91843
 */

public class EmpMain {
	/**
	 * @param args
	 */
	private static final Logger LOGGER = Logger.getLogger("EmpMain");

	public static void main(String[] args) {

		final Employee employee = new Employee();
		employee.setEmpid(102);
		employee.setName("Mansi Roy");
		employee.setEmail("mansi@gmail.com");
		if (LOGGER.isLoggable(Level.INFO)) {
			LOGGER.info("Name -->" + employee.getName());
		}
	}
}