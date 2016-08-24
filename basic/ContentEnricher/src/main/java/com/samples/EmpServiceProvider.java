package com.samples;

import com.samples.jaxb.Employee;

public class EmpServiceProvider {
	
   public String getSsn (Employee emp) {
		
	   if("Jh121".equals(emp.getEmpId()))
		   return "234-456-2341";
	   else 
		   return "456-432-0987";
	}
}
