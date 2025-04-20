package com.project.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EtudiantInfo {
 
    private String nom;
    private long idEtudiant;
    private String email;
    public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


	private String password;
    
    
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public String getApogee() {
		return apogee;
	}
	public void setApogee(String apogee) {
		this.apogee = apogee;
	}

	
	public long getIdEtudiant() {
		return idEtudiant;
	}
	public void setIdEtudiant(long idEtudiant) {
		this.idEtudiant = idEtudiant;
	}


	private String prenom;
	
    private String apogee;


	
    
    // Autres attributs de l'étudiant

    // Constructeurs, getters et setters
}
