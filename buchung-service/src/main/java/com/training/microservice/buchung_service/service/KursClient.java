package com.training.microservice.buchung_service.service;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.training.microservice.buchung_service.model.Kurs;

@FeignClient(name="kurs-service")
interface KursClient {

	@GetMapping("/api/kurs/{kursId}")
	Optional <Kurs> getKurs(@PathVariable("kursId") Long kursId);
}
