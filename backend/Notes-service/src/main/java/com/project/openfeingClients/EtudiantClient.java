package com.project.openfeingClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.response.EtudiantInfo;

@FeignClient(name = "Etudiant", path = "/api/etudiants", url = "${service.etudiant.url}")
public interface EtudiantClient {

    @GetMapping("/{id}")
    public EtudiantInfo getEtudiantById(@PathVariable long id);
    @GetMapping("/emailAndPassword")
    EtudiantInfo getEtudiantByEmailAndPassword(@RequestParam("email") String email,@RequestParam("password") String password);
}
