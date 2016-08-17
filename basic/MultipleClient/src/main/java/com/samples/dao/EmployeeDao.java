package com.samples.dao;

public class EmployeeDao {

	/* Get employee details from database*/
	public Employee getEmployee(Employee emp) {
		
		if("Jh121".equals(emp.getEmpId())) {
			emp.setFirstName("John");
			emp.setLastName("Travolta");
			emp.setYearsOfExperience(25);
		} else {
			emp.setFirstName("Arnold");
			emp.setLastName("Schwarzenegger");
			emp.setYearsOfExperience(35);
		}
         return emp;			

	}
}
