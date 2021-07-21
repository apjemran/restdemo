package com.example.demo.service.usermgmt;

import java.util.List;

import com.example.demo.model.usermgmt.UserDetails;

public interface UserMgmtService {
	
	public List<UserDetails> findAll();
	public void save(UserDetails userDetails);
	public void findUserById(Long id);	

}
