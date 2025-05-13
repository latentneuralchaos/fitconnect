package com.training.microservice.booking_service.service;

import lombok.Data;

@Data
public class BookingRequest {

	private Long userId;
	
	private Long courseId;

	public Long getUserId() {
		return courseId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}
	
	
}
