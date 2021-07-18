package com.example.demo.restcontroller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.usermgmt.UserMgmtService;





@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/usermgmt")
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);	
	
   
    // standard constructors
    @Autowired
    private UserMgmtService userMgmtService;

    @GetMapping("/users")
    public List<User> getUsers() {
    	logger.debug("Start of getting user");
    	logger.debug("This is a debug message");
        logger.info("This is an info message");
        logger.warn("This is a warn message");
        logger.error("This is an error message");
        return userMgmtService.findAll();
    }

    @PostMapping("/users")
    public void addUser(@RequestBody User user) {
    	userMgmtService.save(user);
    }
}
