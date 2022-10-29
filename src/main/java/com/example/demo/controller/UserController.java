package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.UserRepository;
import com.example.demo.dao.EmailRepository;
import com.example.demo.user.EmailClass;
import com.example.demo.user.UserClass;

@RestController
public class UserController {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private EmailRepository emailRepository;

	@PostMapping("/user")
	public String saveUser(@RequestBody UserClass user) {
		userRepository.save(user);
		return "User saved..";
	}

	@GetMapping("/users")
	public List<UserClass> getAll() {
		return userRepository.findAll();
	}

	@GetMapping("/user/{id}")
	public List<UserClass> getUserById(@PathVariable Long id) {
		return userRepository.findById(id);
	}
	
	@PostMapping("/email")
	public Long saveEmail(@RequestBody EmailClass email) {
		
		Long id = userRepository.updateCount(email.sender, email);
		emailRepository.save(email);
		return id;
//		return email.sender.id;
	}
	
	@GetMapping("/emails")
	public List<EmailClass> getAllEmails() {
		return emailRepository.findAll();
	}
	
	@GetMapping("/email/{id}")
	public List<EmailClass> getEmailById(@PathVariable Long id) {
		return emailRepository.findById(id);
	}
	
	@GetMapping("/emails/count")
	public long getCountById(@RequestParam String user) {
//		wo count kar raha hai jitne bhi baar wo number uss object mei dikh raha hai
		return emailRepository.count();
	}
}
