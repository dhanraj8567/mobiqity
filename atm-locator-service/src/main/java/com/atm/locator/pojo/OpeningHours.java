package com.atm.locator.pojo;

import java.io.Serializable;
import java.util.List;

public class OpeningHours implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int dayOfWeek;
	
	private List<Hours> hours;

	public int getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(int dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public List<Hours> getHours() {
		return hours;
	}

	public void setHours(List<Hours> hours) {
		this.hours = hours;
	}
	
	

}
