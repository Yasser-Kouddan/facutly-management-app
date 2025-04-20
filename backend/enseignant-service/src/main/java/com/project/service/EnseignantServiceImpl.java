package com.project.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.EnseignantDAO;
import com.project.dto.EnseignantDTO;
import com.project.model.Enseignant;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EnseignantServiceImpl implements EnseignantService {

    @Autowired
    private EnseignantDAO enseignantDAO;

    @Override
    public EnseignantDTO addEnseignant(EnseignantDTO enseignantDTO) {
        Enseignant enseignant = new Enseignant();
        BeanUtils.copyProperties(enseignantDTO, enseignant);
        Enseignant savedEnseignant = enseignantDAO.save(enseignant);
        EnseignantDTO savedEnseignantDTO = new EnseignantDTO();
        BeanUtils.copyProperties(savedEnseignant, savedEnseignantDTO);
        return savedEnseignantDTO;
    }
    private EnseignantDTO convertToDTO(Enseignant enseignant) {
        EnseignantDTO enseignantDTO = new EnseignantDTO();
        BeanUtils.copyProperties(enseignant, enseignantDTO);
        return enseignantDTO;
    }


    @Override
    public EnseignantDTO getEnseignantById(long idEnseignant) {
        Optional<Enseignant> optionalEnseignant = enseignantDAO.findById(idEnseignant);
        if (optionalEnseignant.isPresent()) {
            Enseignant enseignant = optionalEnseignant.get();
            return convertToDTO(enseignant);
        }
        return null;
    }


    @Override
    public EnseignantDTO updateEnseignant(long id, EnseignantDTO enseignantDTO) {
        Enseignant enseignant = enseignantDAO.findById(id).orElse(null);
        if (enseignant != null) {
            BeanUtils.copyProperties(enseignantDTO, enseignant);
            Enseignant updatedEnseignant = enseignantDAO.save(enseignant);
            EnseignantDTO updatedEnseignantDTO = new EnseignantDTO();
            BeanUtils.copyProperties(updatedEnseignant, updatedEnseignantDTO);
            return updatedEnseignantDTO;
        }
        return null;
    }

    @Override
    public void deleteEnseignant(long id) {
        if (enseignantDAO.existsById(id)) {
            enseignantDAO.deleteById(id);
        }
    }

    @Override
    public List<EnseignantDTO> getAllEnseignants() {
        List<Enseignant> enseignants = enseignantDAO.findAll();
        List<EnseignantDTO> enseignantDTOs = new ArrayList<>();
        for (Enseignant enseignant : enseignants) {
            EnseignantDTO enseignantDTO = new EnseignantDTO();
            BeanUtils.copyProperties(enseignant, enseignantDTO);
            enseignantDTOs.add(enseignantDTO);
        }
        return enseignantDTOs;
    }
   
    public EnseignantDTO findEnseignantByEmailAndPassword(String email, String password) {
        Enseignant enseignant = enseignantDAO.findEnseignantByEmailAndPassword(email, password);
        EnseignantDTO enseignantDTO = new EnseignantDTO();
        BeanUtils.copyProperties(enseignant, enseignantDTO);
        return enseignantDTO;
    }

    @Override
    public EnseignantDTO login(String email, String password) {
        EnseignantDTO enseignantDTO = findEnseignantByEmailAndPassword(email, password);
        
        if (enseignantDTO != null) {
            // L'enseignant est authentifié avec succès
            return enseignantDTO;
        } else {
            // Si l'authentification échoue, vous pouvez renvoyer null ou lever une exception, selon votre choix de gestion des erreurs.
            return null;
        }
    }

    




    

}
