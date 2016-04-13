package com.jcs.controllers;

import java.io.IOException;
import java.util.Arrays;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;

@Provider
public class CORSFilter implements ContainerResponseFilter {

	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
		
		String [] originsAllowed = {"https://652f7991.ngrok.io","https://jivedemo-slicesoftware.jiveon.com/","https://jivedemo-slicesoftware.jiveon.com","http://localhost:63342","http://www.jcsdemo.com","http://www.jcsdemo.com/*","http://www.jcsdemo.com.preview.services","http://jcsdemo.com/*"};
		String origin = requestContext.getHeaders().getFirst("Origin");
		System.out.println(origin);
		System.out.println("FILTERRRRRR");
		if(Arrays.asList(originsAllowed).contains(origin)) {
			MultivaluedMap<String, Object> headers = responseContext.getHeaders();
			headers.add("Access-Control-Allow-Origin", origin);
			headers.add("Access-Control-Allow-Methods", "GET,POST,PUT,DELETE,OPTIONS,HEAD");
			headers.add("Access-Control-Allow-Headers", "Content-Type, Origin");
			headers.add("X-Powered-By", "https://jcs.marketo");			
		}
		else{
			System.out.println("Not allowed ");
		}
	}
}