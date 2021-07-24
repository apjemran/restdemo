package com.example.demo.usermgmt.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.usermgmt.model.UserDetails;
import com.example.demo.usermgmt.service.UserMgmtService;





@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/usermgmt")
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);	
	
   
    // standard constructors
    @Autowired
    private UserMgmtService userMgmtService;

    @GetMapping("/users")
    public List<UserDetails> getUsers() {
    	logger.debug("Start of getting user");    	
        return userMgmtService.findAll();
    }

    @PostMapping("/adduser")
    public void addUser(@RequestBody UserDetails userDetails) {
    	logger.debug("Start add user");
    	userMgmtService.save(userDetails);
    }
    
    @GetMapping("/userbyid")
    public UserDetails findUserById(@RequestParam Long id) {
    	logger.debug("Start searching user by Id: {}",id);
    	return userMgmtService.findUserById(id);
    }
}
