package com.training.microservice.course_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.microservice.course_service.model.User;


public interface UserRepository extends JpaRepository<User, Long>{

}
