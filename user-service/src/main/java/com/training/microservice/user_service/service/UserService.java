package com.training.microservice.user_service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.microservice.user_service.model.User;
import com.training.microservice.user_service.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public List<User> getUsers() {
		return repository.findAll();
	}
	
	public Optional<User> findUserById(String userId) {
		return repository.findById(Long.valueOf(userId));
	}
	
	public User saveUser(User user) {
		return repository.save(user);
	}	
	
	public void deleteUser(String userId) {
		repository.deleteById(Long.valueOf(userId));
	}
	
	/*
	public void aktualisieren(Long id, Benutzer neuerBenutzer) {
		
	}*/
	
}
