package com.project.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.project.model.Note;

@Repository
public interface NoteDAO extends JpaRepository<Note, Long> {

	List<Note> findByModuleIdAndEtudiantId(long moduleId, long etudiantId);

	List<Note> findByEtudiantId(long etudiantId);
	
}
