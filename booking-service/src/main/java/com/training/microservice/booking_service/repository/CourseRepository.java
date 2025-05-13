package com.training.microservice.booking_service.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.microservice.booking_service.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long>{

	boolean existsById(Long id);
	
	Optional<Course> findById(Long id);
}
