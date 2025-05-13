package com.training.microservice.booking_service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.microservice.booking_service.model.Booking;
import com.training.microservice.booking_service.model.Course;
import com.training.microservice.booking_service.model.User;
import com.training.microservice.booking_service.repository.BookingRepository;

@Service
public class BookingService {

	@Autowired
	private BookingRepository bookingRepository;
	
	@Autowired
	private UserClient userClient;
	
	@Autowired
	private CourseClient courseClient;
	
	
	public Booking createBuchung(BookingRequest request) {
		
		Optional<User> user = userClient.getUser(request.getUserId());
		if(user == null) {
			throw new IllegalArgumentException("User doesn't exist!");
		}
		
		Optional<Course> course = courseClient.getCourse(request.getCourseId());
		if(course == null) {
			throw new IllegalArgumentException("Course existiert nicht!");
		}
		
		Booking booking = new Booking();
		booking.setUser(user.get());
		booking.setCourse(course.get());
		
		return bookingRepository.save(booking);
	}
	
	
	public Booking updateBooking(Long id, BookingRequest request) {
		Booking booking = bookingRepository.findById(id).orElseThrow();
		Course course = courseClient.getCourse(request.getCourseId()).get();
		
		booking.setCourse(course);
		return bookingRepository.save(booking);
	}
	
	public void deleteBooking(Long id) {
		bookingRepository.deleteById(id);
	}
	
	public List<Booking> alleBuchungen() {
		return bookingRepository.findAll();
	}
	
	public List<Booking> getBookingByUserId(Long userId) {
		return bookingRepository.findByUserId(userId);
	}
}
