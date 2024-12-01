package com.nourdine.vetements.repos;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.nourdine.vetements.entities.Boutique;
import com.nourdine.vetements.entities.Vetement;
@RepositoryRestResource(path = "rest")
public interface VetementRepository extends JpaRepository<Vetement, Long> {

	List<Vetement> findByMarqueVet(String marque);
	
	List<Vetement> findByMarqueVetContains(String marque);
	
//	 @Query("select v from Vetement v where v.marqueVet like %?1 and v.prixVet > ?2")
//	List<Vetement> findByMarquePrix(String marque, Double prix);
	
	
	@Query("select v from Vetement v where v.marqueVet like %:marque and v.prixVet > :prix")
	List<Vetement> findByMarquePrix (@Param("marque") String marque,@Param("prix") Double prix);
	
	@Query("select v from Vetement v where v.boutique = ?1")
	List<Vetement> findByBoutique (Boutique boutique);
	
	
	List<Vetement> findByBoutiqueIdBou(Long id);

	List<Vetement> findByOrderByMarqueVetAsc();
	
	@Query("select v from Vetement v order by v.marqueVet ASC, v.prixVet DESC")
	List<Vetement> trierVetementMarquePrix ();

	
}
