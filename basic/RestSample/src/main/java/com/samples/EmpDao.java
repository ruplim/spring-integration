package com.samples;

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
		emp.setSpouse(spouseType);
		
		return emp;
	}
	
	public String deleteEmployee(String empId) {
		
		System.out.println("\n######### Deleted EmpID   ::" + empId);

		return empId;
	}
	public Employee createEmployee(Employee emp) {
		
		//Create New Employee and set the Id
		emp.setEmpId("101");
		System.out.println("\n######### Created Emplyee with EmpID   ::" + emp.getEmpId());
		
		return emp;
	}

}
