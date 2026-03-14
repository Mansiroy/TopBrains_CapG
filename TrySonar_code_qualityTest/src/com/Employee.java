package com;

/**
 * @author 91843
 */

public class Employee {
	/**
	 * 
	 */
	private int empid;
	/**
	 * 
	 */
	private String name;
	/**
	 * 
	 */
	private String email;
	/**
	 * 
	 */

	public Employee() {
		this.name = "MYNAME";
		this.empid = 101;
		this.email = "mansi@Gmail.com";

	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(final int empid) {
		this.empid = empid;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

}
