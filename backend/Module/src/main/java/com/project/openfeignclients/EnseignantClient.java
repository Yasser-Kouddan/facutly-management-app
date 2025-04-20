package com.project.openfeignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.project.response.EnseignantInfo;

@Component
@FeignClient(name = "Enseignant", path = "/api/enseignants", url = "${service.enseignant.url}")
public interface EnseignantClient {
	
	@GetMapping("/{id}")
	public EnseignantInfo getEnseignantById(@PathVariable long id);

}
