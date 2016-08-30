package com.samples;

import java.util.List;

import com.samples.jaxb.EmpList;
import com.samples.jaxb.Employee;
import com.samples.jaxb.ObjectFactory;
import com.samples.jaxb.SpouseType;

public class EmpDao {
	
	public Employee getEmployee(String empId) {
		
		System.out.println("\n######### Received EmpID   ::" + empId);
		
		ObjectFactory factory = new ObjectFactory();
		SpouseType spouseType = factory.createSpouseType();
		spouseType.setName("Heidi");
		spouseType.setAge("43");
		
		Employee emp = factory.createEmployee();
		emp.setEmpId(empId);
		emp.setEmpFirstName("Stephen");
		emp.setEmpLastName("Brian");
		emp.setEmpSsn("342-452-0987");
		emp.setSpouse(spouseType);

		if("Jh121".equals(empId))
			emp.setEmpSsn("111-111-1111");
		
		return emp;
	}

	public EmpList searchEmployee(EmployeeSearchDTO edto) {
		
		System.out.println("\n######### Received Search Data   ::" + edto);

		ObjectFactory factory = new ObjectFactory();	
		
		SpouseType spouseType1 = factory.createSpouseType();
		spouseType1.setName("Heidi");
		spouseType1.setAge("43");
		
		Employee emp1 = factory.createEmployee();
		emp1.setEmpId("234");
		emp1.setEmpFirstName("Stephen");
		emp1.setEmpLastName("Brian");
		emp1.setEmpSsn("342-452-0987");
		emp1.setSpouse(spouseType1);

		SpouseType spouseType2 = factory.createSpouseType();
		spouseType2.setName("Rachel");
		spouseType2.setAge("40");
		
		Employee emp2 = factory.createEmployee();
		emp2.setEmpId("234");
		emp2.setEmpFirstName("John");
		emp2.setEmpLastName("Krammer");
		emp2.setEmpSsn("392-452-0985");
		emp2.setSpouse(spouseType2);
		
		EmpList empList = factory.createEmpList();
		List<Employee> emps = empList.getEmployee();
		
		emps.add(emp1);
		emps.add(emp2);

		return empList;
	}
	
	
	public String deleteEmployee(String empId) {
		
		System.out.println("\n######### Deleted EmpID   ::" + empId);
		return empId;
	}
	public Employee createEmployee(Employee emp) {
		
		//Create New Employee and set the Id
		emp.setEmpId("101");
		System.out.println("\n######### Created Employee with EmpID   ::" + emp.getEmpId());
		
		return emp;
	}
	
	public Employee updateEmployee(Employee emp) {
		
		//Update Employee
		System.out.println("\n######### Updated Employee with EmpID   ::" + emp.getEmpId());
		return emp;
	}

}
