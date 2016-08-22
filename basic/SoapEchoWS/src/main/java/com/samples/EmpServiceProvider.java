package com.samples;

import org.springframework.messaging.Message;

public class EmpServiceProvider {
	
   	
    public Message<?> echoMessage(Message<?> msg) {
		
		System.out.println("  ############ In echoMessage ::" + msg);        
		return msg;
	}

}
