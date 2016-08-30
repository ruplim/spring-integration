package com.samples;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public class Init {

/*	
	public static void main(String[] args) {
		

		RestTemplate restTemplate = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		//headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Accept", MediaType.APPLICATION_XML_VALUE);
		HttpEntity<?> entity = new HttpEntity<>(headers);

		HttpEntity<com.samples.jaxb.Employee> response = restTemplate.exchange(
		        "http://localhost:8080/RestSample/emps/100", 
		        HttpMethod.GET, 
		        entity, 
		        com.samples.jaxb.Employee.class);
		
		System.out.println(response.getBody().getEmpId() + ":" + response.getBody().getEmpFirstName());
		
	}
*/	
}
