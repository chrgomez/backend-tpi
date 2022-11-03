package com.utn.ds.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utn.ds.model.Propiedad;

public interface PropiedadRepository extends JpaRepository<Propiedad, Long> {
	List<Propiedad> findByDescripcionContaining(String title);
}
