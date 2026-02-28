package CaseStudy;

public class Main {


	    public static void main(String[] args) {

	        System.out.println("Total Salary:");
	        System.out.println(EmployeeService.getTotalSalary());

	        System.out.println("\nEmployee Count By Department:");
	        System.out.println(EmployeeService.getEmployeeCountByDepartment());

	        System.out.println("\nSenior Most Employee:");
	        System.out.println(EmployeeService.getSeniorMostEmployee().orElse(null));

	        System.out.println("\nEmployee Service Duration:");
	        EmployeeService.getEmployeeServiceDuration();

	        System.out.println("\nEmployees Without Department:");
	        System.out.println(EmployeeService.getEmployeesWithoutDepartment());

	        System.out.println("\nDepartments Without Employees:");
	        System.out.println(EmployeeService.getDepartmentsWithoutEmployees());

	        System.out.println("\nDepartment With Highest Employees:");
	        System.out.println(EmployeeService.getDepartmentWithHighestEmployees().orElse(null));
	    }
	}