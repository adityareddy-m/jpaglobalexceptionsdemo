package com.sample.jpaglobalexceptiondemo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sample.jpaglobalexceptiondemo.entities.User;
import com.sample.jpaglobalexceptiondemo.service.UserRepositoryService;

@RestController
@RequestMapping("/user")
public class UserRepositoryController {
	
	@Autowired
	UserRepositoryService service;
	
	@GetMapping("/{city}")
	User getUserDetails(@RequestParam(value="city") String city) throws Exception {
		return service.getUserdetailsByCity(city);
	}
	
	@PostMapping("/")
	public User addUser(@RequestBody User user) {
		return service.saveUserDetails(user);
	}
	
	@GetMapping("{userId}")
	public Optional<User> recieveUser(@RequestParam(value="userId") Integer userId) {
		return service.findUser(userId);
	}
	
	@GetMapping("/{username}")
	public List<User> getUserBynameLike(@RequestParam(value="username") String username) throws Exception {
		return service.getUserNameLike(username);
	}
	
	@PutMapping("/")
	public User updateUser(@RequestBody User user) {
		return service.updateUserByName(user);
	}
	
	@GetMapping("/lastname")
	public List<User> getUsersBySort(@RequestParam(value= "lastname") String lastname){
		return service.getUsersBySort(lastname);
	}
	
	@GetMapping("/firstname/lastname")
	public List<User> getDistinctUsers(@RequestParam(value="firstname") String firstname,
			@RequestParam(value="lastname") String lastname){
		return service.obtainDistinctUser(firstname, lastname);
	}
	
		
}
