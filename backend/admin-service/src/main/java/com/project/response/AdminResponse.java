package com.project.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AdminResponse {
    private String username;
    private String password;
    // Ajoutez ici d'autres attributs si nécessaire

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

	public void setMessage(String string) {
		// TODO Auto-generated method stub
		
	}
}
