package com.samples;

import org.springframework.messaging.handler.annotation.Header;

public class OperationResolver {
	
	public String routeRequest(@Header("ws_soapAction")  String soapAction ) {
	
		String routeTo = "echoPipe";
		//String soapAction = (String)msg.getHeaders().get("ws_soapAction");
		
		if(soapAction.contains("EmpService/getName"))
			routeTo = "getNamePipe";
		else if(soapAction.contains("EmpService/getEligibility"))
			routeTo = "getEligibilityPipe";
		
		return routeTo;
	}
}
