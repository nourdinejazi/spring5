package com.nourdine.vetements.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.nourdine.vetements.entities.Boutique;
import com.nourdine.vetements.entities.Vetement;

public interface VetementService {
	Vetement saveVetement(Vetement v);

	Vetement updateVetement(Vetement v);

	void deleteVetement(Vetement v);

	void deleteVetementById(Long id);

	Vetement getVetement(Long id);

	List<Vetement> getAllVetements();
	
	Page<Vetement> getAllVetementsParPage(int page, int size);
	
	List<Vetement> findByMarqueVetement(String marque);
	List<Vetement> findByMarqueVetementContains(String marque);
	List<Vetement> findByMarquePrix (String marque, Double prix);
	List<Vetement> findByBoutique (Boutique boutique);
	List<Vetement> findByBoutiqueIdBou(Long id);
	List<Vetement> findByOrderByMarqueVetementAsc();
	List<Vetement> trierVetementsMarquesPrix();

	
	
}
