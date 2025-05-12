package com.training.microservice.course_service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.microservice.course_service.model.Kurs;
import com.training.microservice.course_service.repository.KursRepository;

@Service
public class KursService {

	@Autowired
	private KursRepository repository;
	
	public List<Kurs> alleKurse() {
		return repository.findAll();
	}
	
	public Optional<Kurs> findeNachId(String kursId) {
		return repository.findById(Long.valueOf(kursId));
	}
	
	public Kurs speichern(Kurs kurs) {
		return repository.save(kurs);
	}	
	
	public void loeschen(String kursId) {
		repository.deleteById(Long.valueOf(kursId));
	}
	
	/*
	public void aktualisieren(Long id, Benutzer neuerBenutzer) {
		
	}*/
	
}
