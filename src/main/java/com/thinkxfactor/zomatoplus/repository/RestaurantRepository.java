package com.thinkxfactor.zomatoplus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thinkxfactor.zomatoplus.models.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
	
	public Restaurant findByName(String s);
	public Restaurant findById(long l);
}
