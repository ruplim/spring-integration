package com.samples;

import com.samples.jaxb.Employee;

public class EmployeeDTO {
    
	private String deptId;
    private String empId;
    private String dependent;
    //private String region;
    //private Employee emp;
    private Object payload;
    
    
    public EmployeeDTO() {}

    public EmployeeDTO (String deptId, String empId, String dependent) {
    	this.deptId = deptId;
    	this.empId  = empId;
    	this.dependent = dependent;
    }
    public EmployeeDTO (String deptId, String empId, String dependent, Object payload) {
    	this.deptId = deptId;
    	this.empId  = empId;
    	this.dependent = dependent;
    	this.payload = payload;
    	System.out.println("\n########### payload " + payload);
    
    	
    	
    }
    
/*    public EmployeeDTO (String deptId, String empId, String dependent, String region, Employee emp) {
    	this.deptId = deptId;
    	this.empId  = empId;
    	this.dependent = dependent;
    	this.region    = region;
    	this.emp       = emp;
    }*/
    
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getDependent() {
		return dependent;
	}

	public void setDependent(String dependent) {
		this.dependent = dependent;
	}
/*
	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}
*/

	public Object getPayload() {
		return payload;
	}

	public void setPayload(Object payload) {
		this.payload = payload;
		
	}    
    
	
}
