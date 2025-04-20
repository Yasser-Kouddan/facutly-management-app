package com.project.openfeingClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.project.response.ModuleInfo;

@FeignClient(name = "Module", path = "/api/modules", url = "${service.module.url}")
public interface ModuleClient {

    @GetMapping("/{id}")
    public ModuleInfo getModuleById(@PathVariable long id);
}
