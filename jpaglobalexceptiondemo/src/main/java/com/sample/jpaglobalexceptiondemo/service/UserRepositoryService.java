package com.sample.jpaglobalexceptiondemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.sample.jpaglobalexceptiondemo.entities.User;
import com.sample.jpaglobalexceptiondemo.exceptions.DuplicateUserException;
import com.sample.jpaglobalexceptiondemo.exceptions.UserNotFoundException;
import com.sample.jpaglobalexceptiondemo.repositories.UserRepository;

@Service
public class UserRepositoryService {

	@Autowired
	UserRepository uRepos;
	
	public User getUserdetailsByCity(String city) {
		
		if(uRepos.findByCity(city)!=null) {
			return uRepos.findByCity(city);
		}
		else
			throw new UserNotFoundException("No User in this City");
		
	}
	
	public User saveUserDetails(User user) {
		
		if(getUserByName(user.getName()).getName()!=null) {
			throw new DuplicateUserException("User already registered");
		}
		else
			return uRepos.save(user);
	}
	
	public User getUserByName(String name) {
		return uRepos.findByName(name);
	}
	
	public Optional<User> findUser(Integer userId) {
		return uRepos.findById(userId);
	}
	
	public List<User> getUserNameLike(String name) {
		return uRepos.findByNameContaining(name);
	}
	public User updateUserByName(User user) {
		return uRepos.save(user);
	}
	public List<User> getUsersBySort(String lastname){
		return uRepos.findByLastname(lastname, Sort.by("lastname"));
	}
	
	/*
	 * public List<> obtainUsersByPage(){ return uRepos.findByLastname(lastname,
	 * pageable) }
	 */
	
	public List<User> obtainDistinctUser(String lastname,String firstname){
		return uRepos.findDistinctUserByLastnameOrFirstname(lastname,firstname);
	}
	
	
	
}
