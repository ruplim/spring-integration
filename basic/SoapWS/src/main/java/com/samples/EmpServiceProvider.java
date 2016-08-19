package com.samples;

import org.springframework.messaging.Message;

public class EmpServiceProvider {
	
    public Message getName(Message msg) {
		
		System.out.println("Using Router :: In getName ::" + msg);
		return msg;
	}
	public Message getEligibility(Message msg) {
		
		System.out.println("Using Router :: In getEligibility ::" + msg);
		return msg;
	}	
    public Message echoMessage(Message msg) {
		
		System.out.println("Using Router:: In echoMessage ::" + msg);
		return msg;
	}

}
