package com.samples;



import org.springframework.http.HttpStatus;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;


import com.samples.jaxb.EmpList;
import com.samples.jaxb.Employee;


public class EmpService {
	
	private EmpDao empDao;
	
	public EmpDao getEmpDao() {
		return empDao;
	}
	public void setEmpDao(EmpDao empDao) {
		this.empDao = empDao;
	}
    // Implement GET for /emps/{empId}
	public Message<Employee> get (Message<String> msg) {
		
		String baseUrl = UriUtil.getBaseUri(msg.getHeaders());
        Employee emp   = empDao.getEmployee(msg.getPayload());
        
		return MessageBuilder.withPayload(emp)
                .copyHeadersIfAbsent(msg.getHeaders())
                .setHeader(org.springframework.integration.http.HttpHeaders.STATUS_CODE, HttpStatus.OK)
                .setHeader(org.springframework.http.HttpHeaders.LOCATION,  baseUrl + "/emps/" + emp.getEmpId())
                .build();
	}
	
	//Implement DELETE for /emps/{empId}
	public void delete (String empId) {
		
        empDao.deleteEmployee(empId);
	}

	//Implement PUT for /emps/{empId}
	public void put (Message<Employee> msg) throws Exception {
		
		String empIdFromUri = (String)msg.getHeaders().get("EmpId");
		String empIdFromPayload = msg.getPayload().getEmpId();
		
		if( empIdFromUri.equals(empIdFromPayload))
			empDao.updateEmployee(msg.getPayload());
		else
			throw new Exception ("Emp Id in Uri " + empIdFromUri + " does not match in paylaod " + empIdFromPayload);
	}
	
	
	//Implement POST for /emps
    public Message<Employee> post (Message<Employee> msg) {
    	
    	String baseUrl = UriUtil.getBaseUri(msg.getHeaders());
		Employee emp = empDao.createEmployee(msg.getPayload());

		return MessageBuilder.withPayload(emp)
		                     .copyHeadersIfAbsent(msg.getHeaders())
		                     .setHeader(org.springframework.integration.http.HttpHeaders.STATUS_CODE, HttpStatus.CREATED)
		                     .setHeader(org.springframework.http.HttpHeaders.LOCATION,  baseUrl + "/emps/" + emp.getEmpId())
		                     .build();
	}
    // Implement GET for /emps
	public Message<EmpList> search (Message<EmployeeSearchDTO> msg) {
		
        EmpList empList   = empDao.searchEmployee(msg.getPayload());
        
		return MessageBuilder.withPayload(empList)
                .copyHeadersIfAbsent(msg.getHeaders())
                .setHeader(org.springframework.integration.http.HttpHeaders.STATUS_CODE, HttpStatus.OK)
                .build();
	}
    
}