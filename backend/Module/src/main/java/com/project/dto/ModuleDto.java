package com.project.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
public class ModuleDto {

	private long id;
	private long idEnseignant;
	private String nomModule;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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
