package com.jcs.model;



import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import static javax.persistence.GenerationType.IDENTITY;

public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	@Id
	private int UserID;
	public int getUserID() {
		return UserID;
	}

	private String UserName;
	private String UserEmail;
	private String UserKey;
    private String UserType; 
    private UserInfo userinfo;
    
    
  //  Set<Claim> claim;
    
    
 /*   public Set<Claim> getClaim() {
		return claim;
	}
    @JsonManagedReference
	public void setClaim(Set<Claim> claim) {
		this.claim = claim;
	}*/

	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	

	public void setUserID(int UserInfoID) {
		UserInfoID = UserInfoID;
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
	public UserInfo getUserinfo() {
		return userinfo;
	}
	
	public void setUserinfo(UserInfo userinfo) {
		this.userinfo = userinfo;
	}
	


}
