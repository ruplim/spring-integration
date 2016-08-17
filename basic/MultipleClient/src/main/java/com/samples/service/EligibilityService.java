package com.samples.service;

import com.samples.dao.Employee;

public class EligibilityService {

	public Employee getPromotionEligibility(Employee emp) {
		
		/* Execute the logic/algoritmn to get promotion eligibility*/
		if("John".equals(emp.getFirstName())) 
			emp.setPromotionEligible(true);
		else 
			emp.setPromotionEligible(false);
		
		return emp;
	}
}
