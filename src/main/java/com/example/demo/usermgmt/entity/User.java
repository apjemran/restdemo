package com.example.demo.usermgmt.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class User {
    
    public User(String name, String email) {
		this.name = name;
		this.email = email;
	}
    
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Getter
    private long id;
    private String name;
    private String email;   
    
}
