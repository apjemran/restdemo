package com.example.demo;

import java.util.stream.Stream;

import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.demo.usermgmt.entity.User;
import com.example.demo.usermgmt.entity.UserRepository;

@SpringBootApplication(scanBasePackages = "com.example.demo")
@EnableJpaRepositories("com.example.demo.usermgmt.entity")
@EntityScan("com.example.demo.usermgmt.entity")
public class RestdemoApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(RestdemoApplication.class, args);
	}
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	 @Bean
	 CommandLineRunner init(UserRepository userRepository) {
	        return args -> {
	            Stream.of("John", "Julie", "Jennifer", "Helen", "Rachel").forEach(name -> {
	                User user = new User(name, name.toLowerCase() + "@domain.com");
	                userRepository.save(user);
	            });
	            userRepository.findAll().forEach(System.out::println);
	        };
	 }

}
