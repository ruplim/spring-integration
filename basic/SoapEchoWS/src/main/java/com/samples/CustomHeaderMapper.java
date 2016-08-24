package com.samples;


import javax.xml.namespace.QName;

import org.springframework.integration.ws.DefaultSoapHeaderMapper;
import org.springframework.ws.soap.SoapHeader;
import org.springframework.ws.soap.SoapHeaderElement;
import org.springframework.ws.soap.SoapMessage;


public class CustomHeaderMapper  extends DefaultSoapHeaderMapper {
	
	public CustomHeaderMapper() {
		super();
	}
	@Override
	protected void populateUserDefinedHeader(String headerName, Object headerValue, SoapMessage target) {
				
        if (headerValue instanceof SoapHeaderElement) {
			
			SoapHeader soapHeader = target.getSoapHeader();			
			SoapHeaderElement soapHeaderElement = (SoapHeaderElement) headerValue;
			QName headerQName =soapHeaderElement.getName();
			
			SoapHeaderElement childHeaderElement = soapHeader.addHeaderElement(headerQName);
			childHeaderElement.setText(soapHeaderElement.getText());
		} else 
			super.populateUserDefinedHeader(headerName, headerValue, target);			
	}
}

