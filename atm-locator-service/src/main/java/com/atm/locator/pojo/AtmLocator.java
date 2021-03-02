package com.atm.locator.pojo;

import java.io.Serializable;
import java.util.List;

public class AtmLocator implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Address address;
	
	private int distance;
	
	private List<OpeningHours> openingHours;

	private String functionality;
	
	private String type;

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public List<OpeningHours> getOpeningHours() {
		return openingHours;
	}

	public void setOpeningHours(List<OpeningHours> openingHours) {
		this.openingHours = openingHours;
	}

	public String getFunctionality() {
		return functionality;
	}

	public void setFunctionality(String functionality) {
		this.functionality = functionality;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}
