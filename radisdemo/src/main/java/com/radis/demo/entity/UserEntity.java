package com.radis.demo.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserEntity implements Serializable {

	private static final long serialVersionUID = 7156526077883281623L;
	
	 @Id
     @SequenceGenerator(name = "SEQ_GEN", sequenceName = "SEQ_USER", allocationSize = 1)
     @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GEN")
	 private Long id;
	 private String name;
	 private long followers;
	 
	    public UserEntity(String name, long followers) {
	        this.name = name;
	        this.followers = followers;
	    }

	    //standard getters and setters

	    @Override
	    public String toString() {
	        return String.format("User{id=%d, name='%s', followers=%d}", id, name, followers);
	    }
	 
	 
}
