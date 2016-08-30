package com.samples;

import org.springframework.messaging.Message;

import com.samples.jaxb.Employee;

public class EmpServiceProvider {
	
   public String getSsn (Employee emp) {
		
	   if("Jh121".equals(emp.getEmpId()))
		   return "234-456-2341";
	   else 
		   return "456-432-0987";
	}
   
   public String get(Message<?> msg) {
	   System.out.println("\n##### Got Headers : " + msg.getHeaders());
	   System.out.println("\n##### Got Payload : " + msg.getPayload());
	   
	   
	   
	   return "232-344-2345";
   }
}
