package com.samples;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.xml.namespace.QName;

import org.springframework.integration.ws.DefaultSoapHeaderMapper;
import org.springframework.integration.ws.WebServiceHeaders;
import org.springframework.ws.soap.SoapHeader;
import org.springframework.ws.soap.SoapHeaderElement;
import org.springframework.ws.soap.SoapMessage;

public class CustomHeaderMapper  extends DefaultSoapHeaderMapper {
	
	public CustomHeaderMapper() {
		super();
	}
	
	@Override
	protected Map<String, Object> extractStandardHeaders(SoapMessage source) {
		
		Map<String, Object> standardHeader = super.extractStandardHeaders(source);
		
		/* 
	        Note that SOAPAction value contains a quote :: "EmpService/getName" when posted from SOAP UI 
	        SOAP UI adding double quotes but other clients might not
	        So removing the " from SoapAction String
	    */
		String soapAction = (String)standardHeader.get(WebServiceHeaders.SOAP_ACTION);
		standardHeader.put(WebServiceHeaders.SOAP_ACTION, soapAction.replaceAll("\"",  ""));
		
		return standardHeader;
		
	}
	/*
	 * Filter only 'sessionkey' from header.
	 * Other headers will not be allowed to getthrough
	 * 
	 * */
	@Override
	protected Map<String, Object> extractUserDefinedHeaders(SoapMessage source) {
		
		Map<String, Object> headers = new HashMap<String, Object>();
		SoapHeader soapHeader = source.getSoapHeader();
		if (soapHeader != null) {
			Iterator<?> elementIter = soapHeader.examineAllHeaderElements();
		
			while (elementIter.hasNext()) {
				Object element = elementIter.next();
				if (element instanceof SoapHeaderElement) {
					QName qname = ((SoapHeaderElement) element).getName();
					//Add only sessionkey in header
					if( Constants.CUSTOM_AUTH_SESSION_KEY.equals(qname.getLocalPart())) {
						headers.put(qname.getLocalPart(), ((SoapHeaderElement) element).getText());
					}
				}
			}
		}
		
/*		Set<String>  keys = headers.keySet();		
		for(String key : keys){			
			System.out.println(" ############  extractUserDefinedHeaders   ###### Key :: " + key + "  :: Value -> " + headers.get(key));
		}*/
		
		return headers;		
	}
	@Override
	protected void populateUserDefinedHeader(String headerName, Object headerValue, SoapMessage target) {
				
		if( Constants.CUSTOM_AUTH_SESSION_KEY.equals(headerName)) {
        	
        	SoapHeader soapHeader = target.getSoapHeader();
        	QName sessionKeyQName = new QName(Constants.CUSTOM_AUTH_SESSION_NS, Constants.CUSTOM_AUTH_SESSION_KEY);
        	
        	SoapHeaderElement sessionKeyHeaderElement = soapHeader.addHeaderElement(sessionKeyQName);
        	sessionKeyHeaderElement.setText(headerValue.toString());
        	
        }
		/*  #############  Uncomment if there is a need to add other header elements   ###########
        else if (headerValue instanceof SoapHeaderElement) {
			
			SoapHeader soapHeader = target.getSoapHeader();			
			SoapHeaderElement soapHeaderElement = (SoapHeaderElement) headerValue;
			QName headerQName =soapHeaderElement.getName();
		
			SoapHeaderElement childHeaderElement = soapHeader.addHeaderElement(headerQName);
			childHeaderElement.setText(soapHeaderElement.getText());
			
        } 
        */						
	}
}