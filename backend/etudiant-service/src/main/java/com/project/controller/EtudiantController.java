package com.project.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.project.dto.EtudiantDTO;
import com.project.request.EtudiantRequest;
import com.project.response.EtudiantResponse;
import com.project.service.EtudiantService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/etudiants")
@CrossOrigin("http://localhost:3000")
public class EtudiantController {

    @Autowired
    private EtudiantService etudiantService;

    @PostMapping
    public EtudiantResponse addEtudiant(@RequestBody EtudiantRequest etudiantRequest) {
        EtudiantDTO etudiantDTO = convertToDTO(etudiantRequest);
        EtudiantDTO savedEtudiantDTO = etudiantService.addEtudiant(etudiantDTO);
        return convertToResponse(savedEtudiantDTO);
    }

    @GetMapping("/{id}")
    public EtudiantResponse getEtudiantById(@PathVariable long id) {
        EtudiantDTO etudiantDTO = etudiantService.getEtudiantById(id);
        return convertToResponse(etudiantDTO);
    }

    @GetMapping
    public List<EtudiantResponse> getAllEtudiants() {
        List<EtudiantDTO> etudiantDTOList = etudiantService.getAllEtudiants();
        return etudiantDTOList.stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public EtudiantResponse updateEtudiant(@PathVariable long id, @RequestBody EtudiantRequest etudiantRequest) {
        EtudiantDTO etudiantDTO = convertToDTO(etudiantRequest);
        EtudiantDTO updatedEtudiantDTO = etudiantService.updateEtudiant(id, etudiantDTO);
        return convertToResponse(updatedEtudiantDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteEtudiant(@PathVariable long id) {
        etudiantService.deleteEtudiant(id);
    }

    private EtudiantDTO convertToDTO(EtudiantRequest etudiantRequest) {
        EtudiantDTO etudiantDTO = new EtudiantDTO();
        BeanUtils.copyProperties(etudiantRequest, etudiantDTO);
        return etudiantDTO;
    }

    private EtudiantResponse convertToResponse(EtudiantDTO etudiantDTO) {
        EtudiantResponse etudiantResponse = new EtudiantResponse();
        BeanUtils.copyProperties(etudiantDTO, etudiantResponse);
        return etudiantResponse;
    }
    
    @GetMapping("/emailAndPassword")
    public EtudiantResponse findEtudiantByEmailAndPassword(@RequestParam("email") String email, @RequestParam("password") String password) {
        EtudiantDTO etudiantDTO = etudiantService.findEtudiantByEmailAndPassword(email, password);
        EtudiantResponse etudiantResponse = new EtudiantResponse();
        BeanUtils.copyProperties(etudiantDTO, etudiantResponse);
        return etudiantResponse;
    }
    

    @GetMapping("/apogee/{apogee}")
    public EtudiantResponse findEtudiantByApogee(@PathVariable String apogee) {
        EtudiantDTO etudiantDTO = etudiantService.getEtudiantByApogee(apogee);
        return convertToResponse(etudiantDTO);
    }
    @PostMapping("/login")
    public EtudiantResponse login(@RequestBody EtudiantRequest etudiantRequest) {
        String email = etudiantRequest.getEmail();
        String password = etudiantRequest.getPassword();
        EtudiantDTO etudiantDTO = etudiantService.findEtudiantByEmailAndPassword(email, password);
        return convertToResponse(etudiantDTO);
    }
}
