package com.thinkxfactor.zomatoplus.models;

import java.io.Serializable;


public class Restaurant implements Serializable{
	private String name;
	private String address;
	private int rating;
	private String website;
	private String phoneNo;
	
	public Restaurant() {}

	

	public Restaurant(String name, String address, int rating, String website, String phoneNo) {
		super();
		this.name = name;
		this.address = address;
		this.rating = rating;
		this.website = website;
		this.phoneNo = phoneNo;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	
	
	
}
