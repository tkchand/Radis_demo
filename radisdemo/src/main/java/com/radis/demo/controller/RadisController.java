package com.radis.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.radis.demo.entity.UserEntity;
import com.radis.demo.repository.UserRepository;

@RestController
public class RadisController {

	@Autowired
	private  UserRepository userRepository;
	
	@Cacheable(value = "users", key = "#userId", unless = "#result.followers < 12000")
	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	public Optional getUser(@PathVariable String userId) {
	 
	  return userRepository.findById(Long.valueOf(userId));
	}
	
	@CachePut(value = "users", key = "#user.id")
	@PutMapping("/update")
	public UserEntity updatePersonByID(@RequestBody UserEntity user) {
	  userRepository.save(user);
	  return user;
	}
	
	@CacheEvict(value = "users", allEntries=true)
	@DeleteMapping("/{id}")
	public void deleteUserByID(@PathVariable Long id) {
	  System.out.println("deleting person with id {}"+ id);
	  userRepository.deleteById(id);
	}
}
