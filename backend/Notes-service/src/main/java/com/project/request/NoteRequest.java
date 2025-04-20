		package com.project.request;
		
		import lombok.Data;
		
		@Data
		public class NoteRequest {
		    private long etudiantId;
		    private long moduleId;
		    private double note;
			public double getNote() {
				return note;
			}
			public void setNote(double note) {
				this.note = note;
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
		    
		    
		}
