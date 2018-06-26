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

import com.thinkxfactor.zomatoplus.models.User;

import net.bytebuddy.dynamic.TypeResolutionStrategy.Passive;


@RestController //Because we are using RESTful services. Used to create Controllers
@RequestMapping("/user") // maps address of the controller to access. Context path. Class level mapping
public class UserController {

	List<User> l1 = new ArrayList<User>();
	Map<String, String> master = new Hashtable<>();
	
	/*Only sending data from the server to browser
	@GetMapping("/login") // GET request. GET mapping
	public User userLogin() {
		User u1 = new User();
		u1.setUserName("arnb");
		u1.setPassword("pass");
		return u1;
	}
	//The output of the method is displayed on the browser
	*/
	
	//Get data form the user. Invoked by the browser. SAMPLE --> ?user=arnb&pass=pwd
	//Sample HTTP GET URL: http://localhost:8080/user/login?user=arnb&pass=pwd
	//                     <PROTOCOL>://DOMAIN:PORT/RESOURCE/RESOURCE?PARAMNAME1=value&PARAMNAME2=value
	//														? <-- Pass data  &  <-- Append Parameters 
	
	/*
	@GetMapping("/login") 
	public Object userLogin(@RequestParam("user") String username, @RequestParam("pass") String pwd) {
		String s1, s2;
		User u1 = new User();
		if (username.isEmpty() && pwd.isEmpty()) {
			return "Invalid username and password";
		}else if(pwd.isEmpty()) {
			return (String)"Invalid Password";
		}else if(username.isEmpty()) {
			return (String)"Invalid Username";
		}else {
			u1.setUserName(username);
			u1.setPassword(pwd);
			return u1;
		}
	}
	*/
	
	
	//Method to return all the names for a user
	//All Collection Interface subclasses and interfaces return JSON Array Objects
	
	@GetMapping("/all")
	public List<User> userList() {
		return l1;
	}
	
	@PostMapping("/create")
	public Object createUser(@RequestBody User user) {
		System.out.println(user.toString());
		if(master.containsKey(user.getUserName())) {
			return "User already exist";
		}else {
			master.put(user.getUserName(), user.getPassword());
			l1.add(user);
			return "User Added";
		}
	}
	
	@PostMapping("/login")
	public Object userLogin(@RequestParam String username, String pwd) {
		if (username.isEmpty() && pwd.isEmpty()) {
			return "Invalid username and password";
		}else if(pwd.isEmpty()) {
			return (String)"Invalid Password";
		}else if(username.isEmpty()) {
			return (String)"Invalid Username";
		}else {
			if(master.containsKey(username)) {
				System.out.println(master.get(username));
				System.out.println(pwd);
				if(master.get(username).equals(pwd)) {
					return "Successful Login";
				}else {
					return "Password/Username doesn't match";
				}
			}else {
				return "No such user exits";
			}
		}
	}
	
}
