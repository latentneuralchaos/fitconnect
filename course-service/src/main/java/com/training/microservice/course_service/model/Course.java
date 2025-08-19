package com.training.microservice.course_service.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity			
@Data
public class Course {		 // Tabelle in Datenbank 

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;		// Primärschlüssel
	
	private String title;
	
	private String description;
	
	private String category;
	
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User createdBy;

	public Course() {
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getCreatedBy() {
		return createdBy;
	}
	
	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
}
