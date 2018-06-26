package com.thinkxfactor.zomatoplus.controller;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thinkxfactor.zomatoplus.models.Item;
import com.thinkxfactor.zomatoplus.models.Restaurant;;





@RestController
@RequestMapping("/restaurant")

public class RestaurantController {
	
	//Defining runtime Restaurant HashTable object
	Map<String, List<Item>> masterMenu = new Hashtable<>(); 
	List<Restaurant> master = new ArrayList<>();
	
	@PostMapping("/create")
	public Object createResturant(@RequestBody Restaurant rs) {
		System.out.println(master.add(rs));
		List<Item> l1 = new ArrayList<>();
		masterMenu.put(rs.getName(), l1);
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
			masterMenu.put(rm, l);
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
	
}
