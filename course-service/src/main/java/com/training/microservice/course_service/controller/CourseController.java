package com.training.microservice.course_service.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.microservice.course_service.model.Course;
import com.training.microservice.course_service.service.CourseService;

/**
 * HTTP:
 * 	GET:	Lesen
 * 	POST:	Schreiben
 * 	PUT:	Ändern
 * 	DELETE:	Löschen
 */
@RestController
@RequestMapping("/api/course")  							
public class CourseController {	
	
	@Autowired
	private CourseService courseService;
	
	@GetMapping
	public List<Course> alle() {				// http://localhost:8082/api/course
		
		return courseService.allCourses();
	}
	
	@GetMapping("/{courseId}")						// http://localhost:8081/api/course/1
	public Optional <Course> findById(@PathVariable String courseId) {
		return courseService.findeById(courseId);
	}
	
	@PostMapping
	public Course create(@RequestBody Course course) {
		return courseService.save(course);
	}
	
}
