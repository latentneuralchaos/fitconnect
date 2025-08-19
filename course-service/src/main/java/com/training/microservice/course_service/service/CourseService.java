package com.training.microservice.course_service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.training.microservice.course_service.model.Course;
import com.training.microservice.course_service.model.User;
import com.training.microservice.course_service.repository.CourseRepository;
import com.training.microservice.course_service.repository.UserRepository;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private UserRepository userRepository;
	
	public List<Course> allCourses() {
		return courseRepository.findAll();
	}
	
	public Optional<Course> findById(String courseId) {
		return courseRepository.findById(Long.valueOf(courseId));
	}
	
	public List<Course> findCoursesByUserId(Long userId) {
		
		User user = userRepository.findById(userId).orElse(null);
		if(user == null) {
			throw new IllegalArgumentException("Benutzer mit ID: " + userId + " nicht gefunden.");
		}
		
		return courseRepository.findByUser(user);
	}
	
	public Course save(Course course) {
		return courseRepository.save(course);
	}	
	
	public void delete(String courseId) {
		courseRepository.deleteById(Long.valueOf(courseId));
	}
	
	/*
	public void aktualisieren(Long id, Benutzer neuerBenutzer) {
		
	}*/
	
}
