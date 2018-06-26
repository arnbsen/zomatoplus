package com.thinkxfactor.zomatoplus.models;

import java.io.Serializable;
//Creation of a Java Bean : User

import javax.persistence.*;

//All concepts for ORM 

@Entity //Entity is a POJO mapped to the database
@Table(name="tbl_user") //Indicates which table to map the Objects. 'name' is a parameter for mentioning table name


public class User implements Serializable{
	
	@Id //Indicates the primary key in the table to
	@GeneratedValue //Indicates the database to auto generate the primary key (Auto Increment)
	@Column(name="user_id") //Indicates a column to the column name
	private long id;
	
	@Column(name="password")
	private String password;
	
	@Column(name="name", unique=true)
	private String name;
	
	@Column(name="type")
	private String type;
	
	@Column(name="mobile")
	private String mobile;
	
	@Column(name="address")
	private String address;
	
	@Column(name="landmark")
	private String landmark;
	
	@Column(name="pincode")
	private String pincode;
	
	public User() {}

	public User(long id, String password, String name, String type, String mobile, String address,
			String landmark, String pincode) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.type = type;
		
		this.mobile = mobile;
		this.address = address;
		this.landmark = landmark;
		this.pincode = pincode;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	
	
	
}
