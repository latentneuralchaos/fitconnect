package com.training.microservice.buchung_service.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.microservice.buchung_service.model.Benutzer;


public interface BenutzerRepository extends JpaRepository<Benutzer, Long>{

	boolean existsById(Long id);
	
	Optional<Benutzer> findById(Long id);
}
