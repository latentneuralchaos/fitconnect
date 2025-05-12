package com.training.microservice.buchung_service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.microservice.buchung_service.model.Benutzer;
import com.training.microservice.buchung_service.model.Buchung;
import com.training.microservice.buchung_service.model.Kurs;
import com.training.microservice.buchung_service.repository.BuchungRepository;

@Service
public class BuchungService {

	@Autowired
	private BuchungRepository buchungRepository;
	
	@Autowired
	private BenutzerClient benutzerClient;
	
	@Autowired
	private KursClient kursClient;
	
	
	public Buchung createBuchung(BuchungRequest request) {
		
		Optional<Benutzer> benutzer = benutzerClient.getBenutzer(request.getBenutzerId());
		if(benutzer == null) {
			throw new IllegalArgumentException("Benutzer existiert nicht!");
		}
		
		Optional<Kurs> kurs = kursClient.getKurs(request.getKursId());
		if(kurs == null) {
			throw new IllegalArgumentException("Kurs existiert nicht!");
		}
		
		Buchung buchung = new Buchung();
		buchung.setBenutzer(benutzer.get());
		buchung.setKurs(kurs.get());
		
		return buchungRepository.save(buchung);
	}
	
	public List<Buchung> alleBuchungen() {
		return buchungRepository.findAll();
	}
	
	public List<Buchung> getBuchungenByBenutzerId(Long benutzerId) {
		return buchungRepository.findByBenutzerId(benutzerId);
	}
}
