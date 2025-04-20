package com.project.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.project.dto.ModuleDto;
import com.project.openfeignclients.EnseignantClient;
import com.project.request.ModuleRequest;
import com.project.response.ModuleResponse;
import com.project.service.ModuleService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/modules")

@CrossOrigin("http://localhost:3000")
public class ModuleController {
    @Autowired
    ModuleService service;
    @Autowired
    EnseignantClient enseignantClient;

    @PostMapping
    public ModuleResponse addModule(@RequestBody ModuleRequest req) {
        ModuleResponse rep = new ModuleResponse();
        ModuleDto dto = new ModuleDto();
        BeanUtils.copyProperties(req, dto);
        ModuleDto dto1 = service.addModule(dto);
        BeanUtils.copyProperties(dto1, rep);
        return rep;
    }

    @GetMapping("/{id}")
    public ModuleResponse getModuleById(@PathVariable long id) {
        ModuleResponse rep = new ModuleResponse();
        ModuleDto dto = service.getModuleById(id);
        BeanUtils.copyProperties(dto, rep);
        rep.setEnseignant(enseignantClient.getEnseignantById(dto.getIdEnseignant()));
        return rep;
    }

    @GetMapping
    public List<ModuleResponse> getAllModules() {
        List<ModuleDto> moduleDtoList = service.getAllModules();
        return moduleDtoList.stream()
                .map(this::createModuleResponse)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public ModuleResponse updateModuleById(@PathVariable long id, @RequestBody ModuleRequest req) {
        ModuleResponse rep = new ModuleResponse();
        ModuleDto dto = new ModuleDto();
        BeanUtils.copyProperties(req, dto);
        ModuleDto updatedDto = service.updateModuleById(id, dto);
        BeanUtils.copyProperties(updatedDto, rep);
        return rep;
    }

    @DeleteMapping("/{id}")
    public void deleteModuleById(@PathVariable long id) {
        service.deleteModuleById(id);
    }

    private ModuleResponse createModuleResponse(ModuleDto moduleDto) {
        ModuleResponse moduleResponse = new ModuleResponse();
        BeanUtils.copyProperties(moduleDto, moduleResponse);
        moduleResponse.setEnseignant(enseignantClient.getEnseignantById(moduleDto.getIdEnseignant()));
        return moduleResponse;
    }
    
    
}
