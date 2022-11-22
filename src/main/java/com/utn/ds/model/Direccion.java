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
    
    @Column(name = "calle")
    private String calle;
    
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

    public Direccion(String provincia, String ciudad, String calle, String numero, String barrio, String piso, String depto) {
        this.provincia = provincia;
        this.ciudad = ciudad;
        this.calle = calle;
        this.numero = numero;
        this.barrio = barrio;
        this.piso = piso;
        this.depto = depto;
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

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
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
                ", calle=" + calle +
                ", numero=" + numero +
                ", numero=" + numero +
                ", piso=" + piso +
                ", depto=" + depto +
                "]";
    }

}
