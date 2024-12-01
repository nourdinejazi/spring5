package com.nourdine.vetements.entities;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;


@Entity
public class Vetement {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY )
	private Long idVet;
	private String marqueVet;
	private Double prixVet;
	private Date DateAchat;
	private String imagePath;

	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	@OneToMany (mappedBy = "vetement")
	 private List<Image> images;

	
	@ManyToOne
	private Boutique boutique;
	
	
	public Long getIdVet() {
		return idVet;
	}
	public void setIdVet(Long idVet) {
		this.idVet = idVet;
	}
	public String getMarqueVet() {
		return marqueVet;
	}
	public void setMarqueVet(String marqueVet) {
		this.marqueVet = marqueVet;
	}
	public Double getPrixVet() {
		return prixVet;
	}
	public void setPrixVet(Double prixVet) {
		this.prixVet = prixVet;
	}
	public Date getDateAchat() {
		return DateAchat;
	}
	public void setDateAchat(Date dateAchat) {
		DateAchat = dateAchat;
	}
	public Vetement() {
		super();
		 
	}
	public Vetement(String marqueVet, Double prixVet, Date dateAchat) {
		super();
		this.marqueVet = marqueVet;
		this.prixVet = prixVet;
		DateAchat = dateAchat;
	}
	@Override
	public String toString() {
		return "Vetement [idVet=" + idVet + ", marqueVet=" + marqueVet + ", prixVet=" + prixVet + ", DateAchat="
				+ DateAchat + "]";
	}
	public Boutique getBoutique() {
		return boutique;
	}
	public void setBoutique(Boutique boutique) {
		this.boutique = boutique;
	}
	public List<Image> getImages() {
		return images;
	}
	public void setImages(List<Image> images) {
		this.images = images;
	}
 
	
	
	
}
