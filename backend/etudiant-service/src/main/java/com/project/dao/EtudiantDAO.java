package com.project.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.model.Etudiant;

@Repository
public interface EtudiantDAO extends JpaRepository<Etudiant, Long> {

	Optional<Etudiant> findByEmailAndPassword(String email, String password);

	Optional<Etudiant> findByApogee(String apogee);

	public Etudiant findEtudiantByEmailAndPassword(String email, String password);

	

}
