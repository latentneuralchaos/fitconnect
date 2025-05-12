package com.training.microservice.buchung_service.service;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.training.microservice.buchung_service.model.Benutzer;

@FeignClient(name="benutzer-service")
interface BenutzerClient {

	@GetMapping("/api/benutzer/{benutzerId}")
	Optional <Benutzer> getBenutzer(@PathVariable("benutzerId") Long benutzerId);
}
