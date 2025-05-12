package com.training.microservice.buchung_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.microservice.buchung_service.model.Buchung;
import com.training.microservice.buchung_service.service.BuchungRequest;
import com.training.microservice.buchung_service.service.BuchungService;

@RestController
@RequestMapping("/api/buchung")  				
public class BuchungController {	
	
	@Autowired
	private BuchungService buchungService;
	
	@PostMapping
	public Buchung buchen(@RequestBody BuchungRequest request) {
		return buchungService.createBuchung(request);
	}

	@GetMapping("/benutzer/{benutzerId}")
	public List<Buchung> getKurseZuBenutzer(@PathVariable Long benutzerId) {
		return buchungService.getBuchungenByBenutzerId(benutzerId);
	}
	
}
