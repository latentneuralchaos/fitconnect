package com.training.microservice.course_service.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.microservice.course_service.model.Course;
import com.training.microservice.course_service.model.User;
import com.training.microservice.course_service.repository.CourseRepository;
import com.training.microservice.course_service.repository.UserRepository;
import com.training.microservice.course_service.service.CourseService;

/**
 *  CRUD Features
 * 					HTTP-Methode
 * 	C: Create 		POST
 *  R: READ 		GET
 *  U: Update 		PUT
 *  D: Delete 		DELETE
 *  
 */
@RestController
@RequestMapping("/api/course")  							
public class CourseController {	
	
	@Autowired
	private CourseService courseService;

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping
	public List<Course> alle() {				// http://localhost:8082/api/course
		
		return courseService.allCourses();
	}
	
	@GetMapping("/{courseId}")						// http://localhost:8081/api/course/1
	public Optional <Course> findCourseById(@PathVariable String courseId) {
		return courseService.findById(courseId);
	}
	
	
	@PostMapping
	public ResponseEntity<?> createCourse(@RequestBody Course course){
		
		if(course.getCreatedBy() == null || course.getCreatedBy().getId() == null) {
			return ResponseEntity.badRequest().body("Ersteller fehlt.");
		}
	
		Optional<User> userOpt = userRepository.findById(course.getCreatedBy().getId());
		if(userOpt.isEmpty()) {
			return ResponseEntity.badRequest().body("Benutzer nicht gefunden.");
		}
		
		course.setCreatedBy(userOpt.get());
		Course saved = courseService.save(course);
		return ResponseEntity.ok(saved);
	
	}
	
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<?> getCourses(@RequestParam Long userId) {

		try {
			List<Course> courses = courseService.findCoursesByUserId(userId);
			return ResponseEntity.ok(courses);

		} catch (IllegalArgumentException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
}
