package com.training.microservice.user_service.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.microservice.user_service.model.Benutzer;
import com.training.microservice.user_service.service.BenutzerService;

/**
 * HTTP:
 * 	GET:	Lesen
 * 	POST:	Schreiben
 * 	PUT:	Ändern
 * 	DELETE:	Löschen
 */
@RestController
@RequestMapping("/api/benutzer")  				
public class BenutzerController {	
	
	@Autowired
	private BenutzerService benutzerService;
	
	@GetMapping
	public List<Benutzer> alle() {				// http://localhost:8081/api/benutzer
		return benutzerService.alleBenutzer();
	}
	
	@GetMapping("/{benutzerId}")						// http://localhost:8081/api/benutzer/1
	public Optional <Benutzer> findeNachId(@PathVariable String benutzerId) {
		return benutzerService.findeNachId(benutzerId);
	}
	
	@PostMapping
	public Benutzer erzeugen(@RequestBody Benutzer benutzer) {
		return benutzerService.speichern(benutzer);
	}
	
}
