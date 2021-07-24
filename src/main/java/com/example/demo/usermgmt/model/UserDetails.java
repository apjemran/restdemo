package com.example.demo.usermgmt.model;

import java.io.Serializable;

import javax.validation.constraints.Email;

import lombok.Data;

@Data
public class UserDetails implements Serializable{
	
    private static final long serialVersionUID = 6530170537443243373L;
	private long id;
    private String name;
    @Email(message="Email is not valid")
    private String email; 

}
