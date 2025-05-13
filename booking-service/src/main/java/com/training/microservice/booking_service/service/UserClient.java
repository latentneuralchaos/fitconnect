package com.training.microservice.booking_service.service;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.training.microservice.booking_service.model.User;

@FeignClient(name="user-service")
interface UserClient {

	@GetMapping("/api/user/{userId}")
	Optional <User> getUser(@PathVariable("userId") Long userId);
}
