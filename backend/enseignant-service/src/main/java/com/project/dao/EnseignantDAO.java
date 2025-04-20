package com.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.model.Enseignant;

@Repository
public interface EnseignantDAO extends JpaRepository<Enseignant, Long> {

	public Enseignant findEnseignantByEmailAndPassword(String email, String password);

}
