package com.utn.ds.controller;

import com.utn.ds.model.Direccion;
import com.utn.ds.repository.DireccionRepository;
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
public class DireccionController {

    @Autowired
    DireccionRepository direccionRepository;

    @GetMapping("/direcciones")
    public ResponseEntity<List<Direccion>> getAllDirecciones(@RequestParam(required = false) String descripcion) {
        try {
            List<Direccion> direcciones = new ArrayList<Direccion>();

                direccionRepository.findAll().forEach(direcciones::add);

            if (direcciones.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(direcciones, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/direcciones/{id}")
    public ResponseEntity<Direccion> getDireccionById(@PathVariable("id") long id) {
        Optional<Direccion> direccionData = direccionRepository.findById(id);

        if (direccionData.isPresent()) {
            return new ResponseEntity<>(direccionData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/direcciones")
    public ResponseEntity<Direccion> createDireccion(@RequestBody Direccion direccion) {
        try {
            Direccion _direccion = direccionRepository
                    .save(new Direccion(
                            direccion.getProvincia(),
                            direccion.getCiudad(),
                            direccion.getCalle(),
                            direccion.getNumero(),
                            direccion.getBarrio(),
                            direccion.getPiso(),
                            direccion.getDepto()));
            return new ResponseEntity<>(_direccion, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/direcciones/{id}")
    public ResponseEntity<Direccion> updateDireccion(@PathVariable("id") long id, @RequestBody Direccion direccion) {
        Optional<Direccion> direccionData = direccionRepository.findById(id);

        if (direccionData.isPresent()) {
            Direccion _direccion = direccionData.get();
            _direccion.setProvincia(direccion.getProvincia());
            _direccion.setCiudad(direccion.getCiudad());
            _direccion.setCalle(direccion.getCalle());
            _direccion.setNumero(direccion.getNumero());
            _direccion.setBarrio(direccion.getBarrio());
            _direccion.setPiso(direccion.getPiso());
            _direccion.setDepto(direccion.getDepto());

            return new ResponseEntity<>(direccionRepository.save(_direccion), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/direcciones/{id}")
    public ResponseEntity<HttpStatus> deleteDireccion(@PathVariable("id") long id) {
        try {
            direccionRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
