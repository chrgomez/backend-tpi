package com.utn.ds.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "direccion")
public class Direccion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "provincia")
    private String provincia;
    
    @Column(name = "ciudad")
    private String ciudad;
    
    @Column(name = "numero")
    private String numero;
    
    @Column(name = "barrio")
    private String barrio;
    
    @Column(name = "piso")
    private String piso;
    
    @Column(name = "depto")
    private String depto;

    public Direccion() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getDepto() {
        return depto;
    }

    public void setDepto(String depto) {
        this.depto = depto;
    }

    @Override
    public String toString() {
        return "Direccion [id=" + id + 
                ", provincia=" + provincia + 
                ", ciudad=" + ciudad +
                ", numero=" + numero +
                ", numero=" + numero +
                ", piso=" + piso +
                ", depto=" + depto +
                "]";
    }

}
