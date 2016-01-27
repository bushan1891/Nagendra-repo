package com.jcs.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.jcs.model.Claim;
import com.jcs.model.User;
import com.jcs.model.Vehicle;
import com.jcs.service.BoxService;

@Path("/claim")
public class HomeController {

	@GET
	@Path("/Auth")
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getUsers() {

		List<User> usr = new ArrayList<User>();
		BoxService service = new BoxService();
		// service.dummypush();
		try {
			usr = service.fetchAll();
		} catch (Exception e) {

			e.printStackTrace();
		}

		Gson gson = new Gson();
		String Json = null;
		try {
			// Json = gson.toJson(usr);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return usr;
	}

	@GET
	@Path("/Auth1")
	@Produces(MediaType.APPLICATION_JSON)
	public User getuser(@QueryParam(value = "email") String email) {

		// boxservice.dummypush();

		BoxService service = new BoxService();
		User user = new User();
		try {
			user = service.fetchone(email);
		} catch (Exception e) {

			e.printStackTrace();
		}
		System.out.println("i am in" + email);

		return user;
	}

	@GET
	@Path("/claim")
	@Produces(MediaType.APPLICATION_JSON)
	public String getClaim() {

		BoxService service = new BoxService();

		//service.dummypushClaim();

		List<Claim> claim = new ArrayList<Claim>();

		try {
			claim = service.fetchAllClaim();
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		Gson gson = new Gson();
		String Json = null;
		try {
			 Json = gson.toJson(claim);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return Json;
	}
	
	
	@POST
	@Path("/claim/create")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Claim createClaim(@QueryParam(value = "email")String email,Claim claim) {
		
		 
		 System.out.println(claim.getCauseOfLoss());
		 System.out.println(email);
		
		
		return claim;
		
	}
	
	
/*	@POST
	@Path("/claim/create")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Vehicle createVehicle(@QueryParam(value = "email")String email,Vehicle vehicle) {
		
		
		
		
		return vehicle;
	}
	*/
	
	
	
	
	
	
	

}
