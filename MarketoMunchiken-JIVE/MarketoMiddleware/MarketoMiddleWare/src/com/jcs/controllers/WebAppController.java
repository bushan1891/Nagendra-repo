package com.jcs.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONObject;

import com.jcs.exception.AppException;
import com.jcs.modal.jiveObject;
import com.jcs.service.JiveService;

import dev.marketo.samples.Leads.MultipleLeads;
import dev.marketo.samples.Leads.UpsertLeads;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;

@Path("/jive")
public class WebAppController {

	@GET
	@Path("/accountcreated")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String findRes(String jsonRequest) {

		System.out.println(jsonRequest);

		return "called";
	}

	@POST
	@Path("/account-created")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String postHook(String request) throws IOException, AppException {

		JiveService jiveService = new JiveService();
		
		// gets the user id from the pay-load
	/*	Integer userID = jiveService.getUserID(request);
		
		if(userID!=-1){
			
        List<String> emails =  jiveService.getUserEmail(userID.toString());
        List<String> leads = new ArrayList<String>();
        
        for(String email : emails){
		leads.add(MultipleLeads.getLeads("email",email));
		 UpsertLeads.createLead(email);
        }
        
		}*/
        // check if the lead exist else create a new lead 
        
        
        
        
		// function to get the info form jive

		/*
		 * try { List<String> emails= JiveService.getUserEmail("2135");
		 * for(String email : emails) System.out.println(email); } catch
		 * (AppException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */

		// function to create leads in marketo

		//List<String> emails= jiveService.getUserEmail("2135");
		
		Map<String,String> details = jiveService.getUserDetail("2125");

		
		for (Map.Entry<String,String> detail : details.entrySet()) {
		    System.out.println("Key = " + detail.getKey() + ", Value = " + detail.getValue());
		}
		jiveService.getActivities(details.get("activity"));
		
		return "called";
	}

}