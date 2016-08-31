package com.samples;

import org.apache.log4j.Logger;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessagingException;

public class OrderExceptionHandler {
	
	private static final Logger LOGGER = Logger.getLogger(OrderExceptionHandler.class);
	
	public void error(Message<MessagingException> msg) throws Exception {
		
	    LOGGER.error(" #### Error Message ::" + msg.getPayload().getMessage());
	  		
	}
    public void discard(Message<?> msg) {
		
	    LOGGER.error(" #### Discard Message ::" + msg);
	  		
	} 
}
