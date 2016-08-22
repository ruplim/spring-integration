package com.samples;


import javax.xml.namespace.QName;

import org.springframework.integration.ws.DefaultSoapHeaderMapper;
import org.springframework.ws.soap.SoapHeader;
import org.springframework.ws.soap.SoapHeaderElement;
import org.springframework.ws.soap.SoapMessage;
import org.springframework.ws.soap.saaj.SaajSoapHeaderException;
import org.springframework.xml.transform.StringResult;
import org.springframework.xml.transform.StringSource;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

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

