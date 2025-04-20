package com.project.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Module {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idModule;
	private long idEnseignant;
	private String nomModule;

	

	public long getIdEnseignant() {
		return idEnseignant;
	}

	public void setIdEnseignant(long idEnseignant) {
		this.idEnseignant = idEnseignant;
	}

	public String getNomModule() {
		return nomModule;
	}

	public void setNomModule(String nomModule) {
		this.nomModule = nomModule;
	}

}
