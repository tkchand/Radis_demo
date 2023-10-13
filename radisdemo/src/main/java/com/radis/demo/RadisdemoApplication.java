package com.radis.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

 
import com.radis.demo.entity.UserEntity;
import com.radis.demo.repository.UserRepository;

@SpringBootApplication
@EnableCaching
public class RadisdemoApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(RadisdemoApplication.class, args);
	}
	
	@Autowired
	private  UserRepository userRepository;

	  public void run(String... strings) {
	    //Populating embedded database here
	  //  LOG.info("Saving users. Current user count is {}.", userRepository.count());
		  UserEntity shubham = new UserEntity("Shubham", 2000);
		  UserEntity pankaj = new UserEntity("Pankaj", 3000);
		  UserEntity lewis = new UserEntity("Lewis", 550);

	    userRepository.save(shubham);
	    userRepository.save(pankaj);
	    userRepository.save(lewis);
	     
	  }
}
