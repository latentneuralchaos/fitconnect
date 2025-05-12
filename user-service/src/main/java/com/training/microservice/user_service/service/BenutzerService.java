package com.training.microservice.user_service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.microservice.user_service.model.Benutzer;
import com.training.microservice.user_service.repository.BenutzerRepository;

@Service
public class BenutzerService {

	@Autowired
	private BenutzerRepository repository;
	
	public List<Benutzer> alleBenutzer() {
		return repository.findAll();
	}
	
	public Optional<Benutzer> findeNachId(String benutzerId) {
		return repository.findById(Long.valueOf(benutzerId));
	}
	
	public Benutzer speichern(Benutzer benutzer) {
		return repository.save(benutzer);
	}	
	
	public void loeschen(String benutzerId) {
		repository.deleteById(Long.valueOf(benutzerId));
	}
	
	/*
	public void aktualisieren(Long id, Benutzer neuerBenutzer) {
		
	}*/
	
}
