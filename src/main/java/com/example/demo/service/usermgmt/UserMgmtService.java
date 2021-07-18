package com.example.demo.service.usermgmt;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.entity.UserRepository;

@Service
public class UserMgmtService {
	
	private static final Logger logger = LoggerFactory.getLogger(UserMgmtService.class);
	
	@Autowired
	private UserRepository userRepository;


	public List<User> findAll() {		
		logger.debug("This is a service find all method");        
		return (List<User>) userRepository.findAll();
	}

	public void save(User user) {
		logger.debug("This is a service save method");
		userRepository.save(user);		
	}
	
	

}
