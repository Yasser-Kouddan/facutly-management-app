package com.project.service;

import com.project.dao.EtudiantDAO;
import com.project.dto.EtudiantDTO;
import com.project.model.Etudiant;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EtudiantServiceImpl implements EtudiantService {

    @Autowired
    private EtudiantDAO etudiantDAO;

    @Override
    public EtudiantDTO addEtudiant(EtudiantDTO etudiantDTO) {
        Etudiant etudiant = convertToEntity(etudiantDTO);
        Etudiant savedEtudiant = etudiantDAO.save(etudiant);
        return convertToDTO(savedEtudiant);
    }

    @Override
    public EtudiantDTO getEtudiantById(long idEtudiant) {
        Optional<Etudiant> optionalEtudiant = etudiantDAO.findById(idEtudiant);
        if (optionalEtudiant.isPresent()) {
            Etudiant etudiant = optionalEtudiant.get();
            return convertToDTO(etudiant);
        }
        return null;
    }

    @Override
    public List<EtudiantDTO> getAllEtudiants() {
        List<Etudiant> etudiantList = etudiantDAO.findAll();
        return etudiantList.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EtudiantDTO updateEtudiant(long id, EtudiantDTO etudiantDTO) {
        Optional<Etudiant> optionalEtudiant = etudiantDAO.findById(id);
        if (optionalEtudiant.isPresent()) {
            Etudiant etudiant = optionalEtudiant.get();
            BeanUtils.copyProperties(etudiantDTO, etudiant);
            Etudiant updatedEtudiant = etudiantDAO.save(etudiant);
            return convertToDTO(updatedEtudiant);
        }
        return null;
    }

    @Override
    public void deleteEtudiant(long id) {
        etudiantDAO.deleteById(id);
    }

    private Etudiant convertToEntity(EtudiantDTO etudiantDTO) {
        Etudiant etudiant = new Etudiant();
        BeanUtils.copyProperties(etudiantDTO, etudiant);
        return etudiant;
    }

    private EtudiantDTO convertToDTO(Etudiant etudiant) {
        EtudiantDTO etudiantDTO = new EtudiantDTO();
        BeanUtils.copyProperties(etudiant, etudiantDTO);
        return etudiantDTO;
    }
    
    public EtudiantDTO findEtudiantByEmailAndPassword(String email, String password) {
        Etudiant etudiant = etudiantDAO.findEtudiantByEmailAndPassword(email, password);
        EtudiantDTO etudiantDTO = new EtudiantDTO();
        BeanUtils.copyProperties(etudiant, etudiantDTO);
        return etudiantDTO;
    }

    @Override
    public EtudiantDTO getEtudiantByApogee(String apogee) {
        Optional<Etudiant> optionalEtudiant = etudiantDAO.findByApogee(apogee);
        if (optionalEtudiant.isPresent()) {
            Etudiant etudiant = optionalEtudiant.get();
            return convertToDTO(etudiant);
        }
        return null;
    }
    @Override
    public EtudiantDTO login(String email, String password) {
        EtudiantDTO etudiantDTO = findEtudiantByEmailAndPassword(email, password);

        if (etudiantDTO != null) {
            // L'étudiant est authentifié avec succès
            return etudiantDTO;
        } else {
            // Si l'authentification échoue, vous pouvez renvoyer null ou lever une exception, selon votre choix de gestion des erreurs.
            return null;
        }
    }


}
