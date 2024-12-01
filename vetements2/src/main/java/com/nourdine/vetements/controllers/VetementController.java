package com.nourdine.vetements.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nourdine.vetements.entities.Vetement;
import com.nourdine.vetements.service.VetementService;

@Controller
public class VetementController {
	@Autowired
	VetementService vetementService;

	@RequestMapping("/ListeVetements")
	public String listeVetement(ModelMap modelMap, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size) {

		Page<Vetement> vets = vetementService.getAllVetementsParPage(page, size);
		modelMap.addAttribute("vetements", vets);
		modelMap.addAttribute("pages", new int[vets.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		return "listeVetements";
	}

	@RequestMapping("/showCreate")
	public String showCreate() {
		return "createVetement";
	}

	@RequestMapping("/saveVetement")
	public String saveProduit(@ModelAttribute("produit") Vetement vetement, @RequestParam("date") String date,
			ModelMap modelMap) throws ParseException {

		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateAchat = dateformat.parse(String.valueOf(date));
		vetement.setDateAchat(dateAchat);

		Vetement saveVetement = vetementService.saveVetement(vetement);
		String msg = "Vetement enregistré avec Id " + saveVetement.getIdVet();
		modelMap.addAttribute("msg", msg);
		return "createVetement";
	}

	@RequestMapping("/supprimerVetement")
	public String supprimerProduit(@RequestParam("id") Long id, ModelMap modelMap,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size) {
		vetementService.deleteVetementById(id);
		Page<Vetement> vets = vetementService.getAllVetementsParPage(page,
				size);
				modelMap.addAttribute("vetements", vets);
				modelMap.addAttribute("pages", new int[vets.getTotalPages()]);
				modelMap.addAttribute("currentPage", page);
				modelMap.addAttribute("size", size);
		return "listeVetements";
	}

	@RequestMapping("/modifierVetement")
	public String editerProduit(@RequestParam("id") Long id, ModelMap modelMap) {
		Vetement v = vetementService.getVetement(id);
		modelMap.addAttribute("vetement", v);
		return "editerVetement";
	}

	@RequestMapping("/updateVetement")
	public String updateProduit(@ModelAttribute("produit") Vetement vetement, @RequestParam("date") String date,
			ModelMap modelMap) throws ParseException {
//conversion de la date
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateAchat = dateformat.parse(String.valueOf(date));
		vetement.setDateAchat(dateAchat);

		vetementService.updateVetement(vetement);
		List<Vetement> vets = vetementService.getAllVetements();
		modelMap.addAttribute("vetement", vets);
		return "listeVetements";
	}
}
