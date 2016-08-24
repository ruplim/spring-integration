package com.samples;

import org.springframework.integration.ws.WebServiceHeaders;
import org.springframework.messaging.handler.annotation.Header;

public class OperationResolver {
	
	public String routeRequest(@Header(WebServiceHeaders.SOAP_ACTION)  String soapAction ) {
	
		String routeTo = "echoPipe";
		if(soapAction.contains("EmpService/login"))
			routeTo = "loginPipe";
		else if(soapAction.contains("EmpService/getName"))
			routeTo = "getNamePipe";
		else if(soapAction.contains("EmpService/logout"))
			routeTo = "logoutPipe";
		
		return routeTo;
	}
}
