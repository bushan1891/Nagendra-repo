package com.jcs.model;

import java.util.Date;

import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonBackReference;

public class Vehicle implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private int id;
	private String vin;
	private int userid;
	private String claimNumber;
	private int modelYear;
	private String makeDes;
	private String modelDes;
	private String engineDes;
	private String color;
	private String licPlate;
	private String licPlateState;
	private Date licPlateExp;
	private String damageDes;
	private int mileage;
	
	public Vehicle() {};
	
	
	public String getVin() {
		return vin;
	}
	
	public void setVin(String vin)
	{
		this.vin = vin;
	}
	
	public int getModelYear() {
		return modelYear;
	}
	public void setModelYear(int modelYear) {
		this.modelYear = modelYear;
	}
	
	public String getMakeDes() {
		return makeDes;
	}
	public void setMakeDes(String makeDes) {
		this.makeDes = makeDes;
	}
	
	public String getModelDes() {
		return modelDes;
	}
	public void setModelDes(String modelDes) {
		this.modelDes = makeDes;
	}
	
	public String getEngineDes() {
		return engineDes;
	}
	
	public void setEngineDes(String engineDes) {
		this.engineDes = engineDes;
	}
		
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	
	public String getLicPlate() {
		return licPlate;
	}
	
	public void setLicPlate(String licPlate) {
		this.licPlate = licPlate;
	}
	
	public String getLicPlateState() {
		return licPlateState;
	}
	
	public void setLicPlateState(String licPlateState) {
		this.licPlateState = licPlateState;
	}
	
	public Date getLicPlateExp() {
		return licPlateExp;
	}
	
	public void setLicPlateExp(Date licPlateExp) {
		this.licPlateExp = licPlateExp;
	}
	
	
	public String getDamageDes() {
		return damageDes;
	}
	
	public void setDamageDes(String damageDes) {
		this.damageDes = damageDes;
	}
	
	public int getMileage() {
		return mileage;
	}
	
	public void setMileage(int mileage) {
		this.mileage = mileage;
	}


	public String getClaimNumber() {
		return claimNumber;
	}


	public void setClaimNumber(String claimNumber) {
		this.claimNumber = claimNumber;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getUserid() {
		return userid;
	}


	public void setUserid(int userid) {
		this.userid = userid;
	}
	
	
}


