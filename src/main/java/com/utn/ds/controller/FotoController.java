package com.utn.ds.controller;

import com.utn.ds.model.Foto;
import com.utn.ds.repository.FotoRepository;
import com.utn.ds.repository.FotoRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class FotoController {

	@Autowired
	FotoRepository fotoRepository;

	@GetMapping("/fotos")
	public ResponseEntity<List<Foto>> getAllFotos() {
		try {
			List<Foto> fotos = new ArrayList<Foto>();

			fotoRepository.findAll().forEach(fotos::add);

			if (fotos.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(fotos, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/fotos/{id}")
	public ResponseEntity<Foto> getFotoById(@PathVariable("id") long id) {
		Optional<Foto> fotoData = fotoRepository.findById(id);

		if (fotoData.isPresent()) {
			return new ResponseEntity<>(fotoData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/fotos")
	public ResponseEntity<Foto> createFoto(@RequestBody Foto foto) {
		try {
			Foto _foto = fotoRepository
					.save(new Foto(
                                                foto.getUrl(), 
                                                foto.getPropiedad()
                                        ));
			return new ResponseEntity<>(_foto, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/fotos/{id}")
	public ResponseEntity<Foto> updateFoto(@PathVariable("id") long id, @RequestBody Foto foto) {
		Optional<Foto> fotoData = fotoRepository.findById(id);

		if (fotoData.isPresent()) {
			Foto _foto = fotoData.get();
                        _foto.setUrl(foto.getUrl());
                        _foto.setPropiedad(foto.getPropiedad());
			
			return new ResponseEntity<>(fotoRepository.save(_foto), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/fotos/{id}")
	public ResponseEntity<HttpStatus> deleteFoto(@PathVariable("id") long id) {
		try {
			fotoRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/fotos/propiedad/{id}")
	public ResponseEntity<List<Foto>> findByPropiedad(@PathVariable("id") long id) {
		try {
			List<Foto> fotos = fotoRepository.findByPropiedad(id);

			if (fotos.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(fotos, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
