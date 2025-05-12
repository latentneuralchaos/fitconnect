package com.training.microservice.buchung_service.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Buchung {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="benutzer_id")
	private Benutzer benutzer;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="kurs_id")
	private Kurs kurs;
	
	private Date bestellDatum;

	public Buchung() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Benutzer getBenutzer() {
		return benutzer;
	}

	public void setBenutzer(Benutzer benutzer) {
		this.benutzer = benutzer;
	}

	public Kurs getKurs() {
		return kurs;
	}

	public void setKurs(Kurs kurs) {
		this.kurs = kurs;
	}

	public Date getBestellDatum() {
		return bestellDatum;
	}

	public void setBestellDatum(Date bestellDatum) {
		this.bestellDatum = bestellDatum;
	}
	
}
