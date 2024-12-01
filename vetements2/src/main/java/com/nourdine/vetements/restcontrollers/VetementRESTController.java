package com.nourdine.vetements.restcontrollers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nourdine.vetements.entities.Vetement;
import com.nourdine.vetements.service.VetementService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class VetementRESTController {
	@Autowired
	VetementService vetementService;

	@RequestMapping(path="all",method = RequestMethod.GET)
	List<Vetement> getAllVetements() {
		return vetementService.getAllVetements();
	}

	@RequestMapping(value = "/getbyid/{id}", method = RequestMethod.GET)
	public Vetement getVetementById(@PathVariable("id") Long id) {
		return vetementService.getVetement(id);
	}

	@RequestMapping(path="/addvet",method = RequestMethod.POST)
	@PreAuthorize("hasAuthority('ADMIN')")
	public Vetement createVetement(@RequestBody Vetement vetement) {
		return vetementService.saveVetement(vetement);
	}

	@RequestMapping(path="/updatevet",method = RequestMethod.PUT)
	public Vetement updateVetement(@RequestBody Vetement vetement) {
		return vetementService.updateVetement(vetement);
	}

	@RequestMapping(value="/delvet/{id}",method = RequestMethod.DELETE)
	public void deleteVetemenet(@PathVariable("id") Long id) {
		vetementService.deleteVetementById(id);
	}		
	
	
	@RequestMapping(value="/vetsbou/{idBou}",method = RequestMethod.GET)
	public List<Vetement> getVetementByBouId(@PathVariable("idBou") Long idBou) {
	return vetementService.findByBoutiqueIdBou(idBou);
	}
	
	@RequestMapping(value="/vetMarque/{marqueVet}",method = RequestMethod.GET)
	public List<Vetement> findVetementByMarque(@PathVariable("marqueVet") String nom) {
	return vetementService.findByMarqueVetementContains(nom);
	}

}
