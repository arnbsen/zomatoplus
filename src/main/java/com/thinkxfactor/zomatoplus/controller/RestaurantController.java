package com.thinkxfactor.zomatoplus.controller;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thinkxfactor.zomatoplus.models.Item;
import com.thinkxfactor.zomatoplus.models.Restaurant;
import com.thinkxfactor.zomatoplus.repository.ItemRepository;
import com.thinkxfactor.zomatoplus.repository.RestaurantRepository;;





@RestController
@RequestMapping("/restaurant")

public class RestaurantController {
	
	/*
	//Old Version of Controller
	//Defining runtime Restaurant HashTable object
	Map<Long, List<Item>> masterMenu = new Hashtable<>(); 
	List<Restaurant> master = new ArrayList<>();
	
	@PostMapping("/create")
	public Object createResturant(@RequestBody Restaurant rs) {
		System.out.println(master.add(rs));
		List<Item> l1 = new ArrayList<>();
		masterMenu.put(rs.getId(), l1);
		//System.out.println(rs.toString());
		return rs;
	}
	
	@GetMapping("/all")
	public Object listAllRestaurants() {
		return master;
	}
	
	@PostMapping("/addItem")
	public Object addItem(@RequestBody Item it, String rm) {
		if(masterMenu.containsKey(rm)) {
			List<Item> l = masterMenu.get(rm);
			l.add(it);
			masterMenu.put(Long.parseLong(rm), l);
			return true;
		}else {
			return false;
		}
	}
	
	
	@GetMapping("/listMenuItems")
	public Object listMenuItems(@RequestParam String rm) {
		if(masterMenu.containsKey(rm)) {
			return masterMenu.get(rm);
		}else {
			return false;
		}
	}
	*/
	@Autowired
	private RestaurantRepository restaurantRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	
	@PostMapping("/add")
	public Restaurant add(@RequestBody Restaurant rm) {
		return restaurantRepository.save(rm);
	}
	
	@GetMapping("/getAll")
	public List<Restaurant> getAll() {
		return (List<Restaurant>)restaurantRepository.findAll();
	}
	
	@PostMapping("/addItem")
	public String addItem(@RequestBody Item it,@RequestParam String id) {
		if(restaurantRepository.existsById(Long.parseLong(id))) {
			itemRepository.save(it);
			return "Entry successful";
		}else {
			return "Resturant doesn't exist";
		}
	}
	
	@GetMapping("/listItems")
	public Optional<Item> listItemsById(@RequestParam String id){
		return itemRepository.findById(Long.parseLong(id));
	}
	
}
