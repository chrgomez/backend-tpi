package com.utn.ds.controller;

import com.utn.ds.model.Foto;
import com.utn.ds.model.Propiedad;
import com.utn.ds.repository.PropiedadRepository;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PropiedadController {

    @Autowired
    PropiedadRepository propiedadRepository;

    @GetMapping("/propiedades")
    public ResponseEntity<List<Propiedad>> getAllPropiedades(@RequestParam(required = false) String descripcion) {
        try {
            List<Propiedad> propiedades = new ArrayList<Propiedad>();

            if (descripcion == null) {
                propiedadRepository.findAll().forEach(propiedades::add);
            } else {
                propiedadRepository.findByDescripcionContaining(descripcion).forEach(propiedades::add);
            }

            if (propiedades.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(propiedades, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/propiedades/{id}")
    public ResponseEntity<Propiedad> getPropiedadById(@PathVariable("id") long id) {
        Optional<Propiedad> propiedadData = propiedadRepository.findById(id);

        if (propiedadData.isPresent()) {
            return new ResponseEntity<>(propiedadData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/propiedades")
    public ResponseEntity<Propiedad> createPropiedad(@RequestBody Propiedad propiedad) {
        try {
            Propiedad _propiedad = propiedadRepository
                    .save(new Propiedad(
                            propiedad.getCodPropiedad(),
                            propiedad.getMedidas(),
                            propiedad.getAntiguedad(),
                            propiedad.isAmueblado(),
                            propiedad.getCantHabitaciones(),
                            propiedad.getServicios(),
                            propiedad.getDescripcion(),
                            propiedad.isDisponibilidad(),
                            propiedad.getTipo(),
                            propiedad.getPrecio(),
                            propiedad.getDireccion(),
                            propiedad.getFotos(),
                            propiedad.getCliente()));
            return new ResponseEntity<>(_propiedad, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/propiedades/{id}")
    public ResponseEntity<Propiedad> updatePropiedad(@PathVariable("id") long id, @RequestBody Propiedad propiedad) {
        Optional<Propiedad> propiedadData = propiedadRepository.findById(id);

        if (propiedadData.isPresent()) {
            Propiedad _propiedad = propiedadData.get();
            _propiedad.setCodPropiedad(propiedad.getCodPropiedad());
            _propiedad.setMedidas(propiedad.getMedidas());
            _propiedad.setAntiguedad(propiedad.getAntiguedad());
            _propiedad.setAmueblado(propiedad.isAmueblado());
            _propiedad.setCantHabitaciones(propiedad.getCantHabitaciones());
            _propiedad.setServicios(propiedad.getServicios());
            _propiedad.setDescripcion(propiedad.getDescripcion());
            _propiedad.setDisponibilidad(propiedad.isDisponibilidad());
            _propiedad.setTipo(propiedad.getTipo());
            _propiedad.setPrecio(propiedad.getPrecio());
            _propiedad.setDireccion(propiedad.getDireccion());
            _propiedad.setFotos(propiedad.getFotos());
            _propiedad.setCliente(propiedad.getCliente());

            return new ResponseEntity<>(propiedadRepository.save(_propiedad), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/propiedades/{id}")
    public ResponseEntity<HttpStatus> deletePropiedad(@PathVariable("id") long id) {
        try {
            propiedadRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/propiedad/{id}/fotos")
    public ResponseEntity<List<Foto>> getPropiedadFotos(@PathVariable("id") long id) {
        Optional<Propiedad> propiedadData = propiedadRepository.findById(id);

        if (propiedadData.isPresent()) {
            return new ResponseEntity<>(propiedadData.get().getFotos(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

}
