package com.sample.jpaglobalexceptiondemo.repositories;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sample.jpaglobalexceptiondemo.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	User findByCity(String city);
	
	User findByName(String name);
	
	List<User> findByNameContaining(String name);
	
	List<User> findByLastname(String lastname, Sort sort);

	//List<User> findByLastname(String lastname, Pageable pageable);
	
	List<User> findDistinctUserByLastnameOrFirstname(String lastname, String firstname);
	

	
}
