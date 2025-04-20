package com.project.service;

import java.util.List;

import com.project.dto.ModuleDto;

public interface ModuleService {
    public ModuleDto addModule(ModuleDto module);
    public ModuleDto getModuleById(long id);
	ModuleDto updateModuleById(long id, ModuleDto moduleDto);
	List<ModuleDto> getAllModules();
	void deleteModuleById(long id);
	
}
