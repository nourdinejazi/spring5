package com.nourdine.vetements.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "marqueVet", types = { Vetement.class })
public interface VetementProjection {
  public String getMarqueVet();
}
