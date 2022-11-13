package com.utn.ds.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "tipo_propiedad")
public class TipoPropiedad implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "nombre")
    private String nombre;

    public TipoPropiedad() {

    }

    public TipoPropiedad(String nombre) {
        this.nombre = nombre;
    }

    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Tipo Propiedad [id=" + id + ", nombre=" + nombre + "]";
    }

}
