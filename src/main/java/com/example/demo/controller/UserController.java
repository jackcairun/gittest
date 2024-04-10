package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@RestController
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/user/{id}")
	public User getUser(@PathVariable("id") Integer id) {
		Optional<User> user = userRepository.findById(id);
		return user.orElse(null);
	}
	
	@GetMapping("/user")
	public User inserUser(User user) {
		User save = userRepository.save(user);
		System.out.println("更新1");
		System.out.println("更新2");
		System.out.println("更新3");
		return save;
	}

}
