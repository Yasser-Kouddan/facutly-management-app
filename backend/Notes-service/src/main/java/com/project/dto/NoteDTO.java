package com.project.dto;

import lombok.Data;

@Data
public class NoteDTO {
    private long id;
    private long etudiantId;
    private double note;
	public double getNote() {
		return note;
	}
	public void setNote(double note) {
		this.note = note;
	}
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

	
	private long moduleId;
   
    
    // Ajoutez ici les getters et les setters si nécessaire
}
