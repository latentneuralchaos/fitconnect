package com.training.microservice.buchung_service.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.microservice.buchung_service.model.Kurs;

public interface KursRepository extends JpaRepository<Kurs, Long>{

	boolean existsById(Long id);
	
	Optional<Kurs> findById(Long id);
}
