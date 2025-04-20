package com.project.service;

import com.project.dto.NoteDTO;

import java.util.List;

public interface NoteService {
    NoteDTO addNote(NoteDTO note);
    NoteDTO getNoteById(long id);
    List<NoteDTO> getAllNotes();
    NoteDTO updateNote(long id, NoteDTO note);
    void deleteNote(long id);
	List<NoteDTO> getNoteByModuleAndEtudiant(long moduleId, long etudiantId);
	List<NoteDTO> getNotesByEtudiant(long etudiantId);
	

	
}
