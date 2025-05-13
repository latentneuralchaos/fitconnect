package com.training.microservice.booking_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.microservice.booking_service.model.Booking;
import com.training.microservice.booking_service.service.BookingRequest;
import com.training.microservice.booking_service.service.BookingService;

// localhost:8084/api/booking/user/1 - GET
// localhost:8084/api/booking - POST
@RestController
@RequestMapping("/api/booking")  				
public class BookingController {	
	
	@Autowired
	private BookingService bookingService;
	
	@PostMapping
	public Booking book(@RequestBody BookingRequest request) {
		return bookingService.createBuchung(request);
	}

	@GetMapping("/user/{userId}")
	public List<Booking> getCoursesForUser(@PathVariable Long userId) {
		return bookingService.getBookingByUserId(userId);
	}
	
	@PutMapping("/{id}")
	public Booking updateBooking(@PathVariable Long id, @RequestBody BookingRequest request) {
		return bookingService.updateBooking(id, request);
	}
	
	@DeleteMapping("/{id}")
	public void deleteBooking(@PathVariable Long id) {
		bookingService.deleteBooking(id);
	}
}
