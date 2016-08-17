package com.samples.dao;

public class Employee {

	private String empId;
	private String firstName;
	private String lastName;
	private int yearsOfExperience;
	private boolean promotionEligible = false;
	
	
	public Employee() {}
	
	public Employee(String empId) {
		this.empId = empId;
		
	}		
	
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getYearsOfExperience() {
		return yearsOfExperience;
	}
	public void setYearsOfExperience(int yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}
	public boolean isPromotionEligible() {
		return promotionEligible;
	}
	public void setPromotionEligible(boolean promotionEligible) {
		this.promotionEligible = promotionEligible;
	}
	
	public String toString() {
		
		return  firstName + "," + lastName  + "," + yearsOfExperience + "," + promotionEligible;
	}
}
