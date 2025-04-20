package com.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    private long etudiantId;
    public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getEtudiantId() {
		return etudiantId;
	}
	public void setEtudiantId(long etudiantId) {
		this.etudiantId = etudiantId;
	}
	public long getModuleId() {
		return moduleId;
	}
	public void setModuleId(long moduleId) {
		this.moduleId = moduleId;
	}

	private double note;
	public double getNote() {
		return note;
	}
	public void setNote(double note) {
		this.note = note;
	}


	private long moduleId;
   
    
    
    // Ajoutez ici les getters et les setters si nécessaire
}
