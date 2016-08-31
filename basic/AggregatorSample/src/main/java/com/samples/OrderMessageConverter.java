package com.samples;



import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;

import com.ibm.jms.JMSTextMessage;
import com.samples.jaxb.Order;

import org.springframework.integration.xml.transformer.UnmarshallingTransformer;


public class OrderMessageConverter implements MessageConverter {

	private UnmarshallingTransformer unmarshallingTransformer;

	public UnmarshallingTransformer getUnmarshallingTransformer() {
		return unmarshallingTransformer;
	}

	public void setUnmarshallingTransformer(UnmarshallingTransformer unmarshallingTransformer) {
		this.unmarshallingTransformer = unmarshallingTransformer;
	}
	
	/* Get called when message is pulled from queue*/
	public Object fromMessage(Message msg) throws JMSException, MessageConversionException {

		if(msg instanceof JMSTextMessage) {
			String payload = ((JMSTextMessage)msg).getText();
			Order order = (Order)unmarshallingTransformer.transformPayload(payload);
			return order;
		}
		return null;
		
	}
	/* Get called when message is posted to queue */
	public Message toMessage(Object obj, Session session) throws JMSException, MessageConversionException {
		// TODO Auto-generated method stub
		return null;
	}
}
