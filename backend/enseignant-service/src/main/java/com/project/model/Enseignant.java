package com.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Enseignant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEnseignant;
    public long getIdEnseignant() {
		return idEnseignant;
	}

	public void setIdEnseignant(long idEnseignant) {
		this.idEnseignant = idEnseignant;
	}

	private String nom;
    private String prenom;
    private String email;
    private String departement;
    private String password;
    // Ajoutez ici d'autres attributs si nécessaire

    // Ajoutez ici les getters et setters si nécessaire
    

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
