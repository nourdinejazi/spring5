package com.nourdine.vetements.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.nourdine.vetements.entities.Image;
import com.nourdine.vetements.entities.Vetement;
import com.nourdine.vetements.repos.ImageRepository;
import com.nourdine.vetements.repos.VetementRepository;

@Service
public class ImageServiceImpl implements ImageService {
	@Autowired
	ImageRepository imageRepository;

	@Autowired
	VetementRepository vetementRepository;

	@Autowired
	VetementService vetementService;

	@Override
	public Image uplaodImageVet(MultipartFile file, Long idVet) throws IOException {
		Vetement v = new Vetement();
		v.setIdVet(idVet);
		return imageRepository.save(Image.builder().name(file.getOriginalFilename()).type(file.getContentType())
				.image(file.getBytes()).vetement(v).build());
	}

	@Override
	public List<Image> getImagesParVet(Long vetId) {
		Vetement v = vetementRepository.findById(vetId).get();
		return v.getImages();
	}

	@Override
	public Image getImageDetails(Long id) throws IOException {
		final Optional<Image> dbImage = imageRepository.findById(id);
		return Image.builder().idImage(dbImage.get().getIdImage()).name(dbImage.get().getName())
				.type(dbImage.get().getType()).image(dbImage.get().getImage()).build();
	}

	@Override
	public ResponseEntity<byte[]> getImage(Long id) throws IOException {
		final Optional<Image> dbImage = imageRepository.findById(id);
		return ResponseEntity.ok().contentType(MediaType.valueOf(dbImage.get().getType()))
				.body(dbImage.get().getImage());
	}

	@Override
	public void deleteImage(Long id) {
		imageRepository.deleteById(id);
	}
}
