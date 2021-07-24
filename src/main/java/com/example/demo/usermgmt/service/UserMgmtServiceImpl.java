package com.example.demo.usermgmt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.usermgmt.entity.User;
import com.example.demo.usermgmt.entity.UserRepository;
import com.example.demo.usermgmt.model.UserDetails;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserMgmtServiceImpl implements UserMgmtService{
	
private static final Logger logger = LoggerFactory.getLogger(UserMgmtServiceImpl.class);
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
    private ModelMapper mapper;   

    @Override
	public List<UserDetails> findAll() {		
		logger.debug("This is a service find all method");		
		return mapToModel(userRepository.findAll());
	}

	@Override
	public void save(UserDetails userDetails) {
		logger.debug("This is a service save method");
		logger.info("Saving user with name: {} and email: {}", userDetails.getName(), userDetails.getEmail());
		userRepository.save(mapToEntity(userDetails));		
	}	

	@Override
	public UserDetails findUserById(Long id) {
		logger.debug("Start finding userid: {}", id);
		Optional<User> result = userRepository.findById(id);
		User user = null;
		if(result.isPresent()) {
			user = result.get();			
		}
		return mapper.map(user, UserDetails.class);				
	}
	
	private List<UserDetails> mapToModel(Iterable<User> iterable){		
		List<UserDetails> userDetails = new ArrayList<>();
		for (User user : iterable) {
			userDetails.add(mapper.map(user, UserDetails.class));			
		}
		return userDetails;
	}
	
	private User mapToEntity(UserDetails userDetails){		
		return mapper.map(userDetails, User.class);
	}


}
