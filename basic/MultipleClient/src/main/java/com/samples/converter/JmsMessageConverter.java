package com.samples.converter;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import com.ibm.jms.JMSTextMessage;
import com.samples.dao.Employee;

import org.springframework.integration.support.MessageBuilder;
import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.messaging.support.GenericMessage;

public class JmsMessageConverter implements MessageConverter {

	/* Get called when message is pushed to Outbound queue */
	public Message toMessage(Object object, Session session) throws JMSException, MessageConversionException {
		
		return session.createTextMessage( ((String)object));
	}	
	/* Get called when message is pulled from Inbound queue */
	public Object fromMessage(Message message) throws JMSException, MessageConversionException {
		String empId = ((JMSTextMessage)message).getText();
		return new Employee(empId);
	}

}
