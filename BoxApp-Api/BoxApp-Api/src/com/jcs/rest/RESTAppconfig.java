package com.jcs.rest;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;

import com.jcs.provider.CORSFilter;

@ApplicationPath("/api")
public class RESTAppconfig extends ResourceConfig {

	public RESTAppconfig(){
		System.out.println("called");
		packages("com.jcs.controller");
		register(CORSFilter.class);
	
		register(MultiPartFeature.class);
	
	}
	
}