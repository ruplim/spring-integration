package com.samples;

import org.springframework.messaging.Message;

import com.samples.jaxb.Employee;

public class EmpServiceProvider {
	

    public Message<?> echoMessage(Message<?> msg) {

    	System.out.println("########## Echoing message " + msg);    	
		return msg;
	}

   public Employee getName (Employee emp) throws Exception {
		
	   if("Jh121".equals(emp.getEmpId())) {
		   emp.setEmpName("Arnold");
		   emp.setEmpSsn("123-345-6543");		   
	   } else {
		   emp.setEmpName("John");
		   emp.setEmpSsn("134-675-2563");		   		   
	   }
	   return emp;
		   
	}
}
