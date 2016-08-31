package com.samples;

import java.io.StringReader;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;

import org.springframework.xml.transform.StringResult;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

public class XmlUtil {

	public static String docAsString(Document doc) {
		try {
			StringResult res = new StringResult();
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.transform(new DOMSource(doc), res);
			
			return res.toString();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	/* Same as above method */
	public static String docToString(Document doc) throws Exception {
		DOMSource source = new DOMSource(doc);
		StringResult stringResult = new StringResult();
		transform(source, stringResult);
		return stringResult.toString();
	}

	
	public static Document getDocumentForString(String strDoc) throws Exception {
		DocumentBuilderFactory builder = DocumentBuilderFactory.newInstance();
		builder.setNamespaceAware(true);

		return builder.newDocumentBuilder().parse(
				new InputSource(new StringReader(strDoc)));
	}

	public static DOMSource getDomSourceForString(String strDoc) throws Exception {
		DOMSource domSource = new DOMSource();
		
		
		domSource.setNode(getDocumentForString(strDoc));
		return domSource;
	}

	public static DOMResult getDomResultForString(String strDoc) throws Exception {
		DOMResult res = new DOMResult();
		transform(getDomSourceForString(strDoc), res);
		return res;
	}

	public static StringResult getStringResultForString(String strDoc) throws Exception {
		StringResult res = new StringResult();
		transform(getDomSourceForString(strDoc), res);
		return res;
	}

	
	public static void transform(Source source, Result res) throws Exception {
		TransformerFactory.newInstance().newTransformer().transform(source, res);
	}
}
