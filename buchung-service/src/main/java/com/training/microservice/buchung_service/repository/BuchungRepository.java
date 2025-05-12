package com.training.microservice.buchung_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.microservice.buchung_service.model.Buchung;
import com.training.microservice.buchung_service.model.Kurs;

public interface BuchungRepository extends JpaRepository<Buchung, Long>{

	List<Buchung> findByBenutzerId(Long benutzerId);
	
	List<Kurs> findByKursId(Long kursId);
}
