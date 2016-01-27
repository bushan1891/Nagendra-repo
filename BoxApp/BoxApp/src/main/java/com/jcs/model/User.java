package com.jcs.model;

import java.io.Serializable;



import com.fasterxml.jackson.annotation.JsonManagedReference;

public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int UserID;
	private String UserName;
	private String UserEmail;
	private String UserKey;
    private String UserType;
	UserInfo userinfo;
    
    
    
    public UserInfo getUserinfo() {
		return userinfo;
	}
    @JsonManagedReference
	public void setUserinfo(UserInfo userinfo) {
		this.userinfo = userinfo;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public int getUserID() {
		return UserID;
	}
	public void setUserID(int userID) {
		UserID = userID;
	}
	public String getUserEmail() {
		return UserEmail;
	}
	public void setUserEmail(String userEmail) {
		UserEmail = userEmail;
	}
	public String getUserKey() {
		return UserKey;
	}
	public void setUserKey(String userKey) {
		UserKey = userKey;
	}
	public String getUserType() {
		return UserType;
	}
	public void setUserType(String userType) {
		UserType = userType;
	}
    
    
    
    

}
