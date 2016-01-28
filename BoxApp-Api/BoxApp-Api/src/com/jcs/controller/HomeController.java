package com.jcs.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
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
		service.dummypush();
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
	@Path("/claims")
	@Produces(MediaType.APPLICATION_JSON)
	public String getClaim(@QueryParam(value = "email") String email) {

		BoxService service = new BoxService();

		// service.dummypushClaim();

		List<Claim> claim = new ArrayList<Claim>();

		try {
			claim = service.fetchAllClaim(email); // get all claims for the
													// particular user
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

	@GET
	@Path("/claims/agent")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Claim> getAgentClaim(@QueryParam(value = "status") String status) {

		BoxService service = new BoxService();
		List<Claim> claim;
		try {
			claim = service.fetchAllClaimPending(status);
			return claim;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	

	@POST
	@Path("/claim/create")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Claim createClaim(@QueryParam(value = "email") String email, Claim claim) {

		BoxService service = new BoxService();

		Claim responseClaim = null;

		try {
			responseClaim = service.createClaim(claim, email);
		} catch (Exception e) {

			e.printStackTrace();
		}
		System.out.println(claim.getCauseOfLoss());
		System.out.println(email);

		return responseClaim;

	}

	@POST
	@Path("/claim/vehicle")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Vehicle createVehicle(@QueryParam(value = "email") String email, Vehicle vehicle) {

		System.out.println(email + vehicle.getClaimNumber());
		BoxService service = new BoxService();

		try {
			Vehicle responseVehicle = service.createVehicle(vehicle, email);
		} catch (Exception e) {

			e.printStackTrace();
		}

		return vehicle;
	}
	
	@PUT
	@Path("/claims/update")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Claim updateClaim(Claim claim){
		
		BoxService service = new BoxService();
		
		Claim c = service.updateClaim(claim);
		
		
		return c;
	}
	
	
	

}
