package com.project.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EnseignantRequest {
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
    public EnseignantRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
