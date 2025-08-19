package com.training.microservice.course_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.microservice.course_service.model.Course;
import com.training.microservice.course_service.model.User;


public interface CourseRepository extends JpaRepository<Course, Long>{

	List<Course> findByUser(User user);
}
