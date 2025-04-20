 	package com.project.response;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
public class ModuleResponse {
	private EnseignantInfo enseignant;
	public EnseignantInfo getEnseignant() {
		return enseignant;
	}
	public void setEnseignant(EnseignantInfo enseignant) {
		this.enseignant = enseignant;
	}
	public long getIdModule() {
		return idModule;
	}
	public void setIdModule(long idModule) {
		this.idModule = idModule;
	}
	public String getNomModule() {
		return nomModule;
	}
	public void setNomModule(String nomModule) {
		this.nomModule = nomModule;
	}
	private long idModule;
	private String nomModule;
}
