package com.project.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ModuleInfo {
    private String nomModule;
    
    // Autres attributs du module

    public String getNomModule() {
        return nomModule;
    }

    public void setNomModule(String nomModule) {
        this.nomModule = nomModule;
    }

   

    // Autres getters et setters pour les attributs supplémentaires
}
