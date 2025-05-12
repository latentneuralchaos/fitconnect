package com.training.microservice.course_service.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity			
@Data
public class Benutzer {		 // Tabelle in Datenbank 

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	// Primärschlüssel
	
	private String name;
	
	private String email;
	
	private String passwort;

	@Override
	public String toString() {
		return "Benutzer [id=" + id + ", name=" + name + ", email=" + email + ", passwort=" + passwort + "]";
	}	
}
