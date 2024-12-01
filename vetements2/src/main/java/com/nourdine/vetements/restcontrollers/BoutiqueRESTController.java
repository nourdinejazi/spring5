package com.nourdine.vetements.restcontrollers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nourdine.vetements.entities.Boutique;
import com.nourdine.vetements.repos.BoutiqueRepository;
 

@RestController
@RequestMapping("/api/bou")
@CrossOrigin("*")
public class BoutiqueRESTController {
	@Autowired
	BoutiqueRepository boutiqueRepository;

	@RequestMapping(method = RequestMethod.GET)
	public List<Boutique> getAllBoutiques() {
		return boutiqueRepository.findAll();
	}

	@RequestMapping(value = "/{idBou}", method = RequestMethod.GET)
	public Boutique getBoutiqueById(@PathVariable("idBou") Long id) {
		return boutiqueRepository.findById(id).get();
	}
}