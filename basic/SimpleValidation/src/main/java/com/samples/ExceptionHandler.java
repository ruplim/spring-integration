package com.samples;

import org.apache.log4j.Logger;
import org.springframework.integration.MessageRejectedException;
import org.springframework.messaging.Message;


public class ExceptionHandler {

	private static final Logger LOGGER = Logger.getLogger(ExceptionHandler.class);
	
	public void process(Message<?> msg) {
			
		Object payload = msg.getPayload();
	    if( payload instanceof MessageRejectedException) {
	    	
	    	MessageRejectedException mre = (MessageRejectedException)payload;
            LOGGER.info(" #### Validation Error ::" + mre.getMessage());
            
		    String failedPayload = (String)mre.getFailedMessage().getPayload();
			LOGGER.info(" #### Failed Payload " + failedPayload);

	    } else
	    	LOGGER.info(" #### Failed Payload Object ::" + payload);
		}
}
