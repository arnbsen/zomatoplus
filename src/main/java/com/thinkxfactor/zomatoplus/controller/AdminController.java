package com.thinkxfactor.zomatoplus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thinkxfactor.zomatoplus.models.Item;
import com.thinkxfactor.zomatoplus.models.Restaurant;
import com.thinkxfactor.zomatoplus.models.User;
import com.thinkxfactor.zomatoplus.repository.ItemRepository;
import com.thinkxfactor.zomatoplus.repository.RestaurantRepository;
import com.thinkxfactor.zomatoplus.repository.UserRepository;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RestaurantRepository restaurantRepository;
	
	@Autowired
	ItemRepository itemRepository;
	
	@PostMapping("/addItem")
	public Item addItem(@RequestBody Item it) {
		if(restaurantRepository.existsById(it.getRestaurantId())) {
			itemRepository.save(it);
			return it;
		}else {
			return it;
		}
	}
	
	@PostMapping("/addRestaurant")
	public Restaurant add(@RequestBody Restaurant rm) {
		return restaurantRepository.save(rm);
	}
	
	@PostMapping("/deleteUser")
	public void deleteUser(@RequestBody User u) {
		 userRepository.deleteById(u.getId());
	}
	
	@PostMapping("/deleteRestaurant")
	public void deleteRestaurant(@RequestBody Restaurant r) {
		restaurantRepository.deleteById(r.getId());
	}
	
	@PostMapping("/deleteItem")
	public void deleteItem(@RequestBody Item r) {
		itemRepository.deleteById(r.getId());
	}
	
}
