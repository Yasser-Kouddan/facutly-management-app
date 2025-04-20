package com.project.service;

import java.util.List;

import com.project.dto.EnseignantDTO;

public interface EnseignantService {
    public EnseignantDTO addEnseignant(EnseignantDTO enseignant);
    public EnseignantDTO getEnseignantById(long id);
	EnseignantDTO updateEnseignant(long id, EnseignantDTO enseignantDTO);
	void deleteEnseignant(long id);
	List<EnseignantDTO> getAllEnseignants();
	public EnseignantDTO findEnseignantByEmailAndPassword(String email, String password);
	public EnseignantDTO login(String email, String password);
}
