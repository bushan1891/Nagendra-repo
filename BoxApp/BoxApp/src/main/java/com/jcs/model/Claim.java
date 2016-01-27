package com.jcs.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Claim {

	@Id
	private int ClaimID;

	public int getClaimID() {
		return ClaimID;
	}

	public void setClaimID(int claimID) {
		ClaimID = claimID;
	}
	
}
