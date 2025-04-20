package com.project.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.ModuleDao;
import com.project.dto.ModuleDto;
import com.project.model.Module;

import java.util.ArrayList;
import java.util.List;

@Service
public class ModuleServiceImpl implements ModuleService {
    @Autowired
    private ModuleDao moduleDao;

    @Override
    public ModuleDto addModule(ModuleDto moduleDto) {
        Module module = new Module();
        BeanUtils.copyProperties(moduleDto, module);
        Module savedModule = moduleDao.save(module);
        ModuleDto savedModuleDto = new ModuleDto();
        BeanUtils.copyProperties(savedModule, savedModuleDto);
        return savedModuleDto;
    }

    @Override
    public ModuleDto getModuleById(long id) {
        Module module = moduleDao.findById(id).orElse(null);
        ModuleDto moduleDto = new ModuleDto();
        if (module != null) {
            BeanUtils.copyProperties(module, moduleDto);
        }
        return moduleDto;
    }

    
    public List<ModuleDto> getAllModules() {
        List<Module> modules = moduleDao.findAll();
        List<ModuleDto> moduleDtos = new ArrayList<>();
        for (Module module : modules) {
            ModuleDto moduleDto = new ModuleDto();
            BeanUtils.copyProperties(module, moduleDto);
            moduleDtos.add(moduleDto);
        }
        return moduleDtos;
    }

    
    public ModuleDto updateModuleById(long id, ModuleDto moduleDto) {
        Module module = moduleDao.findById(id).orElse(null);
        if (module != null) {
            BeanUtils.copyProperties(moduleDto, module);
            Module updatedModule = moduleDao.save(module);
            ModuleDto updatedModuleDto = new ModuleDto();
            BeanUtils.copyProperties(updatedModule, updatedModuleDto);
            return updatedModuleDto;
        }
        return null;
    }

    public void deleteModuleById(long id) {
        if (moduleDao.existsById(id)) {
            moduleDao.deleteById(id);
        }
    }

}
