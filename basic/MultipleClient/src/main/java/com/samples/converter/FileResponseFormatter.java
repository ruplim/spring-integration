package com.samples.converter;

import com.samples.dao.Employee;

public class FileResponseFormatter {
	
	public String convertToFileResponse(Employee emp) {
		return "First Name:" + emp.getFirstName() + "," +
			   "Last Name:"  + emp.getLastName() + "," +
			   "Eligibility:" + emp.isPromotionEligible();
				
				
	}

}
