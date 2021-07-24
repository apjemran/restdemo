package com.example.demo.usermgmt.service;

import java.util.List;

import com.example.demo.usermgmt.model.UserDetails;

public interface UserMgmtService {
	
	public List<UserDetails> findAll();
	public void save(UserDetails userDetails);
	public UserDetails findUserById(Long id);	

}
