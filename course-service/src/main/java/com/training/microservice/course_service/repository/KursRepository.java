package com.training.microservice.course_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.microservice.course_service.model.Kurs;


public interface KursRepository extends JpaRepository<Kurs, Long>{

}
