package com.project.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AdminDTO {
    private long id;
    private String username;
    private String password;
    // Ajoutez ici d'autres attributs si nécessaire
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

    // Ajoutez ici les getters et setters si nécessaire
}
