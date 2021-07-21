package com.example.demo.service.usermgmt;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.usermgmt.UserDetails;
import com.example.demo.usermgmt.entity.User;
import com.example.demo.usermgmt.entity.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserMgmtServiceImpl implements UserMgmtService{
	
private static final Logger logger = LoggerFactory.getLogger(UserMgmtServiceImpl.class);
	
	@Autowired
	private UserRepository userRepository;
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
	public void findUserById(Long id) {
		logger.debug("Start finding userid: {}", id);
		userRepository.findById(id);
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
