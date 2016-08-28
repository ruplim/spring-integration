package com.samples;



import org.springframework.http.HttpStatus;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

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
	
    public Employee getVar1(Message<EmployeeDTO> msg) {
    	
    	EmployeeDTO empDto = msg.getPayload();
    	    	
    	System.out.println("############  Dept Id :" + empDto.getDeptId());
    	System.out.println("############  EmpId:" + empDto.getEmpId());
    	System.out.println("############  Dependent:" + empDto.getDependent());
    	//System.out.println("############  Region:" + empDto.getRegion());
    	//System.out.println("############  EmpId:" + empDto.getEmp().getEmpId());
    	
    	return empDao.getEmployee(empDto.getEmpId());
    	
	}
	
    public Employee getVar2(Message<EmployeeDTO> msg) {
    	
    	EmployeeDTO empDto = msg.getPayload();
    	    	
    	System.out.println("############  Dept Id :" + empDto.getDeptId());
    	System.out.println("############  EmpId:" + empDto.getEmpId());
    	System.out.println("############  Dependent:" + empDto.getDependent());
    	
    	
    	return empDao.getEmployee(empDto.getEmpId());
    	
	}
	
	public Message<?> test (Message<?> msg) {
		
		System.out.println("#############  Inside test " + msg);
		return msg;
	}
	
	
	public void delete (String empId) {
        empDao.deleteEmployee(empId);
	}
	
    public Message<Employee> post (Message<Employee> msg) {
    	
    	System.out.println("#####  msg " + msg);
    	

    	
		Employee emp = empDao.createEmployee(msg.getPayload());
		return MessageBuilder.withPayload(emp)
		                     .copyHeadersIfAbsent(msg.getHeaders())
		                     .setHeader(org.springframework.integration.http.HttpHeaders.STATUS_CODE, HttpStatus.CREATED)
		                     .setHeader(org.springframework.http.HttpHeaders.LOCATION,  "emp/" + emp.getEmpId())
		                     .build();
		
		/*		RequestAttributes rr = org.springframework.web.context.request.RequestContextHolder.currentRequestAttributes();
		ServletRequestAttributes ss;
*/		
        
        //payload-expression="T(org.springframework.web.context.request.RequestContextHolder).requestAttributes.request.queryString
	}
    
    public static void main(String[] args) {
    	
    	
		UriComponents comp =  UriComponentsBuilder.fromHttpUrl("http://localhost:8080/ResrSample/dept/1/emp/2000?dependent=44&region=yy")
		                    .build();
		
	   System.out.println(comp.getFragment());
	   System.out.println(comp.getHost());
	   System.out.println(comp.getPath());
	   System.out.println(comp.getPort());
	   System.out.println(comp.getQuery());
	   System.out.println(comp.getScheme());
	   System.out.println(comp.getSchemeSpecificPart());
	   System.out.println(comp.getPathSegments());
	   System.out.println(comp.getQueryParams());
	   
	   System.out.println(comp.toUri().getRawPath());
	   

    	
    }
}
