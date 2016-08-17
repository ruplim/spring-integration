package com.samples.service;

import com.samples.dao.Employee;
import com.samples.dao.EmployeeDao;

public class EmployeeService {

	private EmployeeDao employeeDao;
	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	
	/* Get the details from employee database*/
	public Employee getEmployeeData(Employee emp) {
		
      	return employeeDao.getEmployee(emp);
    }
}
