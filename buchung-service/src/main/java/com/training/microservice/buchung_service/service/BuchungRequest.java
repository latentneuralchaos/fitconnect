package com.training.microservice.buchung_service.service;

import lombok.Data;

@Data
public class BuchungRequest {

	private Long benutzerId;
	
	private Long kursId;

	public Long getBenutzerId() {
		return benutzerId;
	}

	public void setBenutzerId(Long benutzerId) {
		this.benutzerId = benutzerId;
	}

	public Long getKursId() {
		return kursId;
	}

	public void setKursId(Long kursId) {
		this.kursId = kursId;
	}
	
	
}
