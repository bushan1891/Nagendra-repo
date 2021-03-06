package com.jcs.model;


import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonManagedReference;

public class Claim implements java.io.Serializable{

	private static final long serialVersionUID = 1L;

	
	private String claimID;
	private int userID;
	private String firstName;
	private String lastName;
	private String status;
	private Date lossDate;
	private String causeOfLoss;
	private Date reportedDate;
	private String lossDescription;
	private String assignedAdjuster;	
	private String Vehicle;
	private String AdjustorStatus;
	
	public Claim() {};
	
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Date getLossDate() {
		return lossDate;
	}
	
	public void setLossDate(Date lossDate) {
		this.lossDate = lossDate;
	}
	
	public String getCauseOfLoss() {
		return causeOfLoss;
	}
	
	public void setCauseOfLoss(String causeOfLoss) {
		this.causeOfLoss = causeOfLoss;
	}
	
	public Date getReportedDate() {
		return reportedDate;
	}
	
	public void setReportedDate(Date reportedDate) {
		this.reportedDate = reportedDate;
	}
	
	public String getLossDescription() {
		return lossDescription;
	}
	
	public void setLossDescription(String lossDescription) {
		this.lossDescription = lossDescription;
	}

	public String getAssignedAdjuster() {
		return assignedAdjuster;
	}

	public void setAssignedAdjuster(String assignedAdjuster) {
		this.assignedAdjuster = assignedAdjuster;
	}


	public String getVehicle() {
		return Vehicle;
	}


	public void setVehicle(String vehicle) {
		Vehicle = vehicle;
	}


	public String getClaimID() {
		return claimID;
	}


	public void setClaimID(String claimID) {
		this.claimID = claimID;
	}


	public String getAdjustorStatus() {
		return AdjustorStatus;
	}


	public void setAdjustorStatus(String adjustorStatus) {
		AdjustorStatus = adjustorStatus;
	}


	public int getUserID() {
		return userID;
	}


	public void setUserID(int userID) {
		this.userID = userID;
	}
	
}
