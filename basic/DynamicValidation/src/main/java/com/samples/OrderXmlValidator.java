package com.samples;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.xml.validation.ValidationErrorHandler;
import org.springframework.xml.validation.XmlValidator;
import org.springframework.xml.validation.XmlValidatorFactory;
import org.xml.sax.SAXParseException;

public class OrderXmlValidator implements InitializingBean, XmlValidator{

	private static final Logger LOGGER = Logger.getLogger(OrderXmlValidator.class);
	
	// <namespace, SchemaPath>
	private Map<String, String> schemaMap;
	// <namespace, XMlValidator>
	private Map<String, XmlValidator> validatorMap = new HashMap(); 
	
	public OrderXmlValidator(Map<String, String> schemaMap) {
		this.schemaMap = schemaMap;		
	}
	
	public void afterPropertiesSet() throws Exception {
		
		LOGGER.info("##### Constructing Validators from schema resource list ...");
        
		XmlValidator validator = null;
        for (Map.Entry<String, String> entry : schemaMap.entrySet()) {
            validator = createValidatorFromResourceUri(entry.getValue());
            validatorMap.put(entry.getKey(), validator);
        }	
	}
    private XmlValidator createValidatorFromResourceUri(String schemaPath) throws IOException {
        return XmlValidatorFactory.createValidator(new ClassPathResource(schemaPath), XmlValidatorFactory.SCHEMA_W3C_XML);
    }
    
    /*
    *
    * Source = If it's a String, the validator will pass in a StringSource (you can use source.toString()) to get at the String. 
    *          If it's a Document, you'll get a DOMSource.
    *          
    *   XmlValidatingMessageSelector.accept()   calls DefaultXmlPayloadConverter.convertToSource(). It converts Message -> Source
    *   and passes it to validate()
    *             
    *   Call stack :
    *          org.springframework.integration.xml.DefaultXmlPayloadConverter.convertToSource()
	 *          org.springframework.integration.xml.selector.XmlValidatingMessageSelector.accept()
	 *          
    */    
	public SAXParseException[] validate(Source source) throws IOException {
		
		XmlValidator validator = lookupValidator(source);
        return validator.validate(source);
	}
    private XmlValidator lookupValidator(Source source)  {

        String dataNamespace = getNamespace(source);
        return validatorMap.get(dataNamespace);
    }    
    private String getNamespace(Source source) {
        if (source instanceof DOMSource) {        	
        	return ((DOMSource) source).getNode().getFirstChild().getNamespaceURI();
        }
        LOGGER.warn("### Returning null  for source " + source.getClass());
        return null;
    }

	public SAXParseException[] validate(Source source, ValidationErrorHandler errorHandler) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	

}
