package com.samples;

public class EmployeeSearchDTO {
    
	private String startOffSet;
    private String endOffSet;
    
    public EmployeeSearchDTO(String startOffSet, String endOffSet) {
    	this.startOffSet = startOffSet; 
    	this.endOffSet   = endOffSet;
    }
    
	public String getStartOffSet() {
		return startOffSet;
	}
	public void setStartOffSet(String startOffSet) {
		this.startOffSet = startOffSet;
	}
	public String getEndOffSet() {
		return endOffSet;
	}
	public void setEndOffSet(String endOffSet) {
		this.endOffSet = endOffSet;
	}
	
	public String toString() {
		
		return  "\n##### EmployeeSearchDTO.startOffSet: " + this.startOffSet + 
				"\n##### EmployeeSearchDTO.endOffSet: "   + this.endOffSet;
		
	}
}
