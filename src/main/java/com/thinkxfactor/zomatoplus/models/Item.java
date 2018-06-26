package com.thinkxfactor.zomatoplus.models;

import java.io.Serializable;
import javax.persistence.*;
import javax.annotation.Generated;


@Entity
@Table(name="tbl_item")
public class Item implements Serializable{
	
	
	@Id
	@GeneratedValue
	@Column(name="item_id")
	private long id;
	
	@Column(name="restaurant_id")
	private long restaurantId;
	
	@Column(name="name")
	private String name;

	@Column(name="price")
	private double price;
	
	@Column(name="description")
	private String description;
	
	public Item() {}

	public Item(long id, long restaurant_id, String name, double price, String description) {
		super();
		this.id = id;
		this.restaurantId = restaurant_id;
		this.name = name;
		this.price = price;
		this.description = description;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(long restaurant_id) {
		this.restaurantId = restaurant_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	} 
	
	
	
}
