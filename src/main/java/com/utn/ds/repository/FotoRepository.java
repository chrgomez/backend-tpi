package com.utn.ds.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utn.ds.model.Foto;
import com.utn.ds.model.Propiedad;

public interface FotoRepository extends JpaRepository<Foto, Long> {
	List<Foto> findByPropiedad(long idPropiedad);
}
