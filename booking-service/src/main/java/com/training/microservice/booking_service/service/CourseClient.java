package com.training.microservice.booking_service.service;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.training.microservice.booking_service.model.Course;

@FeignClient(name="course-service")
interface CourseClient {

	@GetMapping("/api/course/{courseId}")
	Optional <Course> getCourse(@PathVariable("courseId") Long courseId);
}
