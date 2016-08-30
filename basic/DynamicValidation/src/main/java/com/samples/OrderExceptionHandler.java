package com.samples;

import org.apache.log4j.Logger;
import org.springframework.integration.MessageRejectedException;
import org.springframework.messaging.Message;
import org.w3c.dom.Document;

public class OrderExceptionHandler {
	
	private static final Logger LOGGER =  Logger.getLogger(OrderExceptionHandler.class);
	public void process(Message<?> msg) throws Exception {
		
		Object payload = msg.getPayload();
		if( payload instanceof MessageRejectedException) {
			
			MessageRejectedException mre = (MessageRejectedException)payload;
			LOGGER.error(" #### Error Message ::" + mre.getMessage());
			
			Object failedPayload = mre.getFailedMessage().getPayload();
			
			LOGGER.error(" #### Failed payload ::\n");
			if( failedPayload instanceof Document) {
				LOGGER.error(XmlUtil.docToString((Document)failedPayload));
			} else 
			   LOGGER.error(mre.getFailedMessage().getPayload());
		}
	}

}
