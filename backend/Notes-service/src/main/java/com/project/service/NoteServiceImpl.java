package com.project.service;

import com.project.dao.NoteDAO;
import com.project.dto.NoteDTO;
import com.project.model.Note;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteDAO noteDAO;

    @Override
    public NoteDTO addNote(NoteDTO noteDTO) {
        Note note = convertToEntity(noteDTO);
        Note savedNote = noteDAO.save(note);
        return convertToDTO(savedNote);
    }

    @Override
    public NoteDTO getNoteById(long id) {
        Optional<Note> optionalNote = noteDAO.findById(id);
        if (optionalNote.isPresent()) {
            Note note = optionalNote.get();
            return convertToDTO(note);
        }
        return null;
    }

    @Override
    public List<NoteDTO> getAllNotes() {
        List<Note> noteList = noteDAO.findAll();
        return noteList.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public NoteDTO updateNote(long id, NoteDTO noteDTO) {
        Optional<Note> optionalNote = noteDAO.findById(id);
        if (optionalNote.isPresent()) {
            Note note = optionalNote.get();
            BeanUtils.copyProperties(noteDTO, note);
            Note updatedNote = noteDAO.save(note);
            return convertToDTO(updatedNote);
        }
        return null;
    }

    @Override
    public void deleteNote(long id) {
        noteDAO.deleteById(id);
    }

    public List<NoteDTO> getNoteByModuleAndEtudiant(long moduleId, long etudiantId) {
        List<Note> noteList = noteDAO.findByModuleIdAndEtudiantId(moduleId, etudiantId);
        return noteList.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<NoteDTO> getNotesByEtudiant(long etudiantId) {
        List<Note> noteList = noteDAO.findByEtudiantId(etudiantId);
        return noteList.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private Note convertToEntity(NoteDTO noteDTO) {
        Note note = new Note();
        BeanUtils.copyProperties(noteDTO, note);
        return note;
    }

    private NoteDTO convertToDTO(Note note) {
        NoteDTO noteDTO = new NoteDTO();
        BeanUtils.copyProperties(note, noteDTO);
        return noteDTO;
    }
}
