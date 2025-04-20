package com.project.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.project.dto.NoteDTO;
import com.project.request.NoteRequest;
import com.project.response.NoteResponse;
import com.project.service.NoteService;

import com.project.openfeingClients.EtudiantClient;
import com.project.openfeingClients.ModuleClient;
import com.project.response.EtudiantInfo;
import com.project.response.ModuleInfo;

@RestController
@RequestMapping("/api/notes")
@CrossOrigin("http://localhost:3000")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @Autowired
    private EtudiantClient etudiantClient;

    @Autowired
    private ModuleClient moduleClient;

    @PostMapping
    public NoteResponse addNote(@RequestBody NoteRequest noteRequest) {
        NoteResponse noteResponse = new NoteResponse();
        NoteDTO noteDTO = new NoteDTO();
        BeanUtils.copyProperties(noteRequest, noteDTO);
        NoteDTO savedNoteDTO = noteService.addNote(noteDTO);
        BeanUtils.copyProperties(savedNoteDTO, noteResponse);

        // Récupérer les informations de l'étudiant via le client EtudiantClient
        EtudiantInfo etudiantInfo = etudiantClient.getEtudiantById(savedNoteDTO.getEtudiantId());
        noteResponse.setEtudiant(etudiantInfo);

        // Récupérer les informations du module via le client ModuleClient
        ModuleInfo moduleInfo = moduleClient.getModuleById(savedNoteDTO.getModuleId());
        noteResponse.setModule(moduleInfo);

        return noteResponse;
    }

    @GetMapping("/{id}")
    public NoteResponse getNoteById(@PathVariable long id) {
        NoteDTO noteDTO = noteService.getNoteById(id);
        NoteResponse noteResponse = new NoteResponse();
        BeanUtils.copyProperties(noteDTO, noteResponse);

        // Récupérer les informations de l'étudiant via le client EtudiantClient
        EtudiantInfo etudiantInfo = etudiantClient.getEtudiantById(noteDTO.getEtudiantId());
        noteResponse.setEtudiant(etudiantInfo);

        // Récupérer les informations du module via le client ModuleClient
        ModuleInfo moduleInfo = moduleClient.getModuleById(noteDTO.getModuleId());
        noteResponse.setModule(moduleInfo);

        return noteResponse;
    }
    @GetMapping
    public List<NoteResponse> getAllNotes() {
        List<NoteDTO> noteDTOList = noteService.getAllNotes();
        List<NoteResponse> noteResponseList = new ArrayList<>();

        for (NoteDTO noteDTO : noteDTOList) {
            NoteResponse noteResponse = new NoteResponse();
            BeanUtils.copyProperties(noteDTO, noteResponse);

            // Récupérer les informations de l'étudiant via le client EtudiantClient
            EtudiantInfo etudiantInfo = etudiantClient.getEtudiantById(noteDTO.getEtudiantId());
            noteResponse.setEtudiant(etudiantInfo);

            // Récupérer les informations du module via le client ModuleClient
            ModuleInfo moduleInfo = moduleClient.getModuleById(noteDTO.getModuleId());
            noteResponse.setModule(moduleInfo);

            noteResponseList.add(noteResponse);
        }

        return noteResponseList;
    }


    @PutMapping("/{id}")
    public NoteResponse updateNote(@PathVariable long id, @RequestBody NoteRequest noteRequest) {
        NoteDTO noteDTO = new NoteDTO();
        BeanUtils.copyProperties(noteRequest, noteDTO);
        NoteDTO updatedNoteDTO = noteService.updateNote(id, noteDTO);
        NoteResponse noteResponse = new NoteResponse();
        BeanUtils.copyProperties(updatedNoteDTO, noteResponse);

        // Récupérer les informations de l'étudiant via le client EtudiantClient
        EtudiantInfo etudiantInfo = etudiantClient.getEtudiantById(updatedNoteDTO.getEtudiantId());
        noteResponse.setEtudiant(etudiantInfo);

        // Récupérer les informations du module via le client ModuleClient
        ModuleInfo moduleInfo = moduleClient.getModuleById(updatedNoteDTO.getModuleId());
        noteResponse.setModule(moduleInfo);

        return noteResponse;
    }

    @DeleteMapping("/{id}")
    public void deleteNote(@PathVariable long id) {
        noteService.deleteNote(id);
    }
   
    @GetMapping("/module/{moduleId}/etudiant/{etudiantId}")
    public List<NoteResponse> getNoteByModuleAndEtudiant(@PathVariable long moduleId, @PathVariable long etudiantId) {
        List<NoteDTO> noteDTOList = noteService.getNoteByModuleAndEtudiant(moduleId, etudiantId);
        List<NoteResponse> noteResponseList = new ArrayList<>();

        for (NoteDTO noteDTO : noteDTOList) {
            NoteResponse noteResponse = new NoteResponse();
            BeanUtils.copyProperties(noteDTO, noteResponse);

            // Récupérer les informations de l'étudiant via le client EtudiantClient
            EtudiantInfo etudiantInfo = etudiantClient.getEtudiantById(noteDTO.getEtudiantId());
            noteResponse.setEtudiant(etudiantInfo);

            // Récupérer les informations du module via le client ModuleClient
            ModuleInfo moduleInfo = moduleClient.getModuleById(noteDTO.getModuleId());
            noteResponse.setModule(moduleInfo);

            noteResponseList.add(noteResponse);
        }

        return noteResponseList;
    }
    @GetMapping("/etudiant/{etudiantId}/notes")
    public List<NoteResponse> getAllNotesByEtudiant(@PathVariable long etudiantId) {
        List<NoteDTO> noteDTOList = noteService.getNotesByEtudiant(etudiantId);
        List<NoteResponse> noteResponseList = new ArrayList<>();

        for (NoteDTO noteDTO : noteDTOList) {
            NoteResponse noteResponse = new NoteResponse();
            BeanUtils.copyProperties(noteDTO, noteResponse);

            // Récupérer les informations de l'étudiant via le client EtudiantClient
            EtudiantInfo etudiantInfo = etudiantClient.getEtudiantById(noteDTO.getEtudiantId());
            noteResponse.setEtudiant(etudiantInfo);

            // Récupérer les informations du module via le client ModuleClient
            ModuleInfo moduleInfo = moduleClient.getModuleById(noteDTO.getModuleId());
            noteResponse.setModule(moduleInfo);

            noteResponseList.add(noteResponse);
        }

        return noteResponseList;
    }
    @GetMapping("/etudiant/login")
    public EtudiantInfo getEtudiantByEmailAndPassword(
        @RequestParam("email") String email,
        @RequestParam("password") String password
    ) {
        EtudiantInfo etudiantInfo = etudiantClient.getEtudiantByEmailAndPassword(email, password);
        return etudiantInfo;
    }

    @GetMapping("/etudiant")
    public List<NoteResponse> getNoteByEtudiantEmailAndPassword(
            @RequestParam String email,
            @RequestParam String password
    ) {
        // Utilisez le client EtudiantClient pour vérifier l'e-mail et le mot de passe de l'étudiant
        EtudiantInfo etudiantInfo = etudiantClient.getEtudiantByEmailAndPassword(email, password);
        
        if (etudiantInfo == null) {
            // L'étudiant n'a pas été trouvé ou les informations d'identification sont incorrectes
            return Collections.emptyList();
        }
        
        List<NoteDTO> noteDTOList = noteService.getNotesByEtudiant(etudiantInfo.getIdEtudiant());
        List<NoteResponse> noteResponseList = new ArrayList<>();

        for (NoteDTO noteDTO : noteDTOList) {
            NoteResponse noteResponse = new NoteResponse();
            BeanUtils.copyProperties(noteDTO, noteResponse);

            // Récupérer les informations de l'étudiant via le client EtudiantClient
            noteResponse.setEtudiant(etudiantInfo);

            // Récupérer les informations du module via le client ModuleClient
            ModuleInfo moduleInfo = moduleClient.getModuleById(noteDTO.getModuleId());
            noteResponse.setModule(moduleInfo);

            noteResponseList.add(noteResponse);
        }

        return noteResponseList;
    }




}

