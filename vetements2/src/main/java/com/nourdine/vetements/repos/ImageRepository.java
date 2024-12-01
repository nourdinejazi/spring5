package com.nourdine.vetements.repos;

 
import org.springframework.data.jpa.repository.JpaRepository;

import com.nourdine.vetements.entities.Image;
 
public interface ImageRepository extends JpaRepository<Image , Long> {
}
