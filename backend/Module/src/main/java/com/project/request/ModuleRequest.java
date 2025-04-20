package com.project.request;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
public class ModuleRequest {
	private long idEnseignant;
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
	private String nomModule;
}
