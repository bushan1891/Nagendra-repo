package com.jcs.webapp;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

import io.swagger.jaxrs.config.BeanConfig;

@ApplicationPath("/api")
public class middleware extends ResourceConfig {

 public	middleware(){
	 // once  /API is parsed it launches the constructor and forwards to package
		packages("Resturant.egen.rest");
	    System.out.println("called");
		//Swagger
		
		/*register(io.swagger.jaxrs.listing.ApiListingResource.class);
		register(io.swagger.jaxrs.listing.SwaggerSerializers.class);
		
		BeanConfig config = new BeanConfig();
		config.setBasePath("/Resturant/api");
		config.setDescription("Resturant API ");
		config.setVersion("1.0");
		config.setSchemes(new String [] {"http"});
		config.setResourcePackage("Resturant.egen");
		config.setTitle("Resturant API");
		config.setScan(true);*/
		
		
 }
	
}