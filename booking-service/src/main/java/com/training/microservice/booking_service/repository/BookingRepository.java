package com.training.microservice.booking_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.microservice.booking_service.model.Booking;
import com.training.microservice.booking_service.model.Course;

public interface BookingRepository extends JpaRepository<Booking, Long>{

	List<Booking> findByUserId(Long userId);
	
	List<Course> findByCourseId(Long courseId);
}
