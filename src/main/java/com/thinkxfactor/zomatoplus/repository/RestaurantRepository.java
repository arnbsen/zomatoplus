package com.thinkxfactor.zomatoplus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thinkxfactor.zomatoplus.models.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
	
	public Restaurant findByName(String s);
	public Restaurant findById(long l);
	public List<Restaurant> findAllByCity(String s);
	public Restaurant findAllByCityAndName(String s1, String s2);
	

}
