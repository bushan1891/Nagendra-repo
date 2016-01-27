package com.jcs.model;

import java.io.Serializable;



import com.fasterxml.jackson.annotation.JsonManagedReference;
public class UserInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int UserID;
	private String address;
	private long phone;
	private String title;
	private String email;
	
	public int getUserID() {
		return UserID;
	}
	public void setUserID(int userID) {
		UserID = userID;
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
}
