package com.samples;

import org.springframework.messaging.MessageHeaders;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class UriUtil {
	
	public static String getBaseUri(MessageHeaders msgHeaders) {

		UriComponents restUri =  UriComponentsBuilder.fromHttpUrl((String)msgHeaders.get(org.springframework.integration.http.HttpHeaders.REQUEST_URL))
                                                   .build();
		
		return restUri.getScheme() + "://" + restUri.getHost() + ":" + restUri.getPort() + msgHeaders.get("requestContextPath"); 
	}

}
