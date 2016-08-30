package com.samples;

import org.apache.log4j.Logger;
import org.springframework.messaging.Message;
import org.w3c.dom.Document;

public class OrderProcessor {
	private static final Logger LOGGER = Logger.getLogger(OrderProcessor.class);
	
	public void process(Message<Document> msg) throws Exception {
		
	    LOGGER.info(" #### Succesfully processed :\n" + XmlUtil.docToString(msg.getPayload()));	
	}

}
