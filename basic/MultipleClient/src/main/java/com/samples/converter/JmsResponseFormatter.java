package com.samples.converter;

import com.samples.dao.Employee;

public class JmsResponseFormatter {
	
	public String convertToJmsResponse(Employee emp) {
		return emp.toString();
	}

}
