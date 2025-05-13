package com.training.microservice.booking_service.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.microservice.booking_service.model.User;


public interface UserRepository extends JpaRepository<User, Long>{

	boolean existsById(Long id);
	
	Optional<User> findById(Long id);
}
