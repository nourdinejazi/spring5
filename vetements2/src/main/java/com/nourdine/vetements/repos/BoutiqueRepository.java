package com.nourdine.vetements.repos;

 
 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

 import com.nourdine.vetements.entities.Boutique;
@RepositoryRestResource(path = "bou")
@CrossOrigin("http://localhost:4200/") //pour autoriser angular
public interface BoutiqueRepository extends JpaRepository<Boutique, Long> {

}