package com.project.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.project.dto.EnseignantDTO;
import com.project.request.EnseignantRequest;
import com.project.response.EnseignantResponse;
import com.project.service.EnseignantService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/enseignants")
@CrossOrigin("http://localhost:3000")
public class EnseignantController {

    @Autowired
    EnseignantService service;

    @PostMapping
    public EnseignantResponse addEnseignant(@RequestBody EnseignantRequest enseignantRequest) {
        EnseignantResponse enseignantResponse = new EnseignantResponse();
        EnseignantDTO enseignantDTO = new EnseignantDTO();
        BeanUtils.copyProperties(enseignantRequest, enseignantDTO);
        EnseignantDTO savedEnseignantDTO = service.addEnseignant(enseignantDTO);
        BeanUtils.copyProperties(savedEnseignantDTO, enseignantResponse);
        return enseignantResponse;
    }

    @GetMapping("/{id}")
    public EnseignantResponse getEnseignantById(@PathVariable long id) {
        EnseignantDTO enseignantDTO = service.getEnseignantById(id);
        return convertToResponse(enseignantDTO);
    }

    
    @GetMapping
    public List<EnseignantResponse> getAllEnseignants() {
        List<EnseignantDTO> enseignantDTOList = service.getAllEnseignants();
        return enseignantDTOList.stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    private EnseignantResponse convertToResponse(EnseignantDTO enseignantDTO) {
        EnseignantResponse enseignantResponse = new EnseignantResponse();
        BeanUtils.copyProperties(enseignantDTO, enseignantResponse);
        return enseignantResponse;
    }
    
    @PutMapping("/{id}")
    public EnseignantResponse updateEnseignant(@PathVariable long id, @RequestBody EnseignantRequest enseignantRequest) {
        EnseignantDTO enseignantDTO = new EnseignantDTO();
        BeanUtils.copyProperties(enseignantRequest, enseignantDTO);
        EnseignantDTO updatedEnseignantDTO = service.updateEnseignant(id, enseignantDTO);
        EnseignantResponse enseignantResponse = new EnseignantResponse();
        BeanUtils.copyProperties(updatedEnseignantDTO, enseignantResponse);
        return enseignantResponse;
    }

    @DeleteMapping("/{id}")
    public void deleteEnseignant(@PathVariable long id) {
        service.deleteEnseignant(id);
    }
    @GetMapping("/emailAndPassword")
    public EnseignantResponse findEnseignantByEmailAndPassword(@RequestParam("email") String email, @RequestParam("password") String password) {
        EnseignantDTO enseignantDTO = service.findEnseignantByEmailAndPassword(email, password);
        EnseignantResponse enseignantResponse = new EnseignantResponse();
        BeanUtils.copyProperties(enseignantDTO, enseignantResponse);
        return enseignantResponse;
    }
    @PostMapping("/login")
    public EnseignantResponse loginEnseignant(@RequestBody EnseignantRequest enseignantRequest) {
        String email = enseignantRequest.getEmail();
        String password = enseignantRequest.getPassword();
        
        EnseignantDTO enseignantDTO = service.findEnseignantByEmailAndPassword(email, password);
        EnseignantResponse enseignantResponse = new EnseignantResponse();
        BeanUtils.copyProperties(enseignantDTO, enseignantResponse);
        return enseignantResponse;
    }
   
    

   

}
