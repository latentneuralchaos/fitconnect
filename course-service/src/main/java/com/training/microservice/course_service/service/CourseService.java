package com.training.microservice.course_service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.microservice.course_service.model.Course;
import com.training.microservice.course_service.repository.CourseRepository;

@Service
public class CourseService {

	@Autowired
	private CourseRepository repository;
	
	public List<Course> allCourses() {
		return repository.findAll();
	}
	
	public Optional<Course> findeById(String courseId) {
		return repository.findById(Long.valueOf(courseId));
	}
	
	public Course save(Course course) {
		return repository.save(course);
	}	
	
	public void delete(String courseId) {
		repository.deleteById(Long.valueOf(courseId));
	}
	
	/*
	public void aktualisieren(Long id, Benutzer neuerBenutzer) {
		
	}*/
	
}
