package com.training.microservice.course_service.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.microservice.course_service.model.Kurs;
import com.training.microservice.course_service.service.KursService;

/**
 * HTTP:
 * 	GET:	Lesen
 * 	POST:	Schreiben
 * 	PUT:	Ändern
 * 	DELETE:	Löschen
 */
@RestController
@RequestMapping("/api/kurs")  				
public class KursController {	
	
	@Autowired
	private KursService kursService;
	
	@GetMapping
	public List<Kurs> alle() {				// http://localhost:8081/api/kurs
		
		return kursService.alleKurse();
	}
	
	@GetMapping("/{kursId}")						// http://localhost:8081/api/kurs/1
	public Optional <Kurs> findeNachId(@PathVariable String kursId) {
		return kursService.findeNachId(kursId);
	}
	
	@PostMapping
	public Kurs erzeugen(@RequestBody Kurs kurs) {
		return kursService.speichern(kurs);
	}
	
}
