package com.samples;

import org.apache.log4j.Logger;
import org.springframework.integration.xml.DefaultXmlPayloadConverter;
import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;

import org.w3c.dom.Document;

import javax.jms.JMSException;
import javax.jms.Session;

import com.ibm.jms.JMSTextMessage;
import com.samples.XmlUtil;

public class OrderMessageConverter implements MessageConverter {

	private static final Logger LOGGER = Logger.getLogger(OrderMessageConverter.class);
	
	private DefaultXmlPayloadConverter xmlPayloadConverter;
	
	public DefaultXmlPayloadConverter getXmlPayloadConverter() {
		return xmlPayloadConverter;
	}
	public void setXmlPayloadConverter(DefaultXmlPayloadConverter xmlPayloadConverter) {
		this.xmlPayloadConverter = xmlPayloadConverter;
	}
	
	/* Get called when message is pulled from Inbound queue */
	public Object fromMessage(javax.jms.Message message) throws JMSException, MessageConversionException {
 
		if( message instanceof JMSTextMessage) {
			
			return getXmlPayloadConverter().convertToDocument(((JMSTextMessage)message).getText());
		}
		throw new MessageConversionException("Failed to convert message" +  message.toString());	
	}
	
	/* Get called when message is pushed to Outbound queue */
	public javax.jms.Message toMessage(Object object, Session session) throws JMSException, MessageConversionException {
		String payload = XmlUtil.docAsString((Document)object);
		LOGGER.info(" #### Posting message to queue :" + payload);
		
        return session.createTextMessage(payload);
	}
	


}
