package com.samples;

import java.util.UUID;

import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.util.StringUtils;

import com.samples.jaxb.Employee;

public class AuthService {

    public Message<?> login(Employee emp) throws Exception {

    	System.out.println("########## logging In User:: " + emp.getEmpId());

    	//Create session key and add to header
    	String sessionKey = UUID.randomUUID().toString();
    	
        return MessageBuilder.withPayload(emp)
        		             .setHeader(Constants.CUSTOM_AUTH_SESSION_KEY, sessionKey)
        		             .build();
	}
    public Message<?> logoff(Message<?> msg) throws Exception {

    	String sessionKeyValue = (String)msg.getHeaders().get(Constants.CUSTOM_AUTH_SESSION_KEY);
    	
    	if( sessionKeyValue == null || StringUtils.isEmpty(sessionKeyValue))
    		throw new Exception("sessionkey is required to logoff");
    	
    	System.out.println("########## logging Out User:: " + msg);
    	
    	//Invalidate the sessionkey
        return MessageBuilder.withPayload(msg.getPayload())
        		             .setHeader(Constants.CUSTOM_AUTH_SESSION_KEY,"Invalidated " + sessionKeyValue )
        		             .build();
	}

    
}
