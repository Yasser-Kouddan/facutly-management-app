	package com.project.response;
	
	import lombok.Data;
	
	@Data
	public class NoteResponse {
	    private long id;
	   
	    private double note;
	    private EtudiantInfo etudiant;
	    private ModuleInfo module;
	
	    public long getId() {
	        return id;
	    }
	
	    public void setId(long id) {
	        this.id = id;
	    }
	
	    
	
	    public double getNote() {
	        return note;
	    }
	
	    public void setNote(double note) {
	        this.note = note;
	    }
	
	    public EtudiantInfo getEtudiant() {
	        return etudiant;
	    }
	
	    public void setEtudiant(EtudiantInfo etudiant) {
	        this.etudiant = etudiant;
	    }
	
	    public ModuleInfo getModule() {
	        return module;
	    }
	
	    public void setModule(ModuleInfo module) {
	        this.module = module;
	    }
	}
