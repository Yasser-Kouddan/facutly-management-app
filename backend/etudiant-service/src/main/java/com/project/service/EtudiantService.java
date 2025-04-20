package com.project.service;

import com.project.dto.EtudiantDTO;

import java.util.List;

public interface EtudiantService {
    EtudiantDTO addEtudiant(EtudiantDTO etudiant);
    EtudiantDTO getEtudiantById(long idEtudiant);
    List<EtudiantDTO> getAllEtudiants();
    EtudiantDTO updateEtudiant(long id, EtudiantDTO etudiant);
    void deleteEtudiant(long id);
	EtudiantDTO findEtudiantByEmailAndPassword(String email, String password);
	EtudiantDTO getEtudiantByApogee(String apogee);
	EtudiantDTO login(String email, String password);
}
