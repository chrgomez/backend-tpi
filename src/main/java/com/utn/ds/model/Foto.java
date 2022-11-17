package com.utn.ds.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "foto")
public class Foto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column(name = "url")
    private String url;
    
    @ManyToOne 
    @JoinColumn(name = "id_propiedad", nullable = false)
    @JsonBackReference
    private Propiedad propiedad;

    public Foto() {

    }

    public Foto(String url, Propiedad propiedad) {
        this.url = url;
        this.propiedad = propiedad;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Propiedad getPropiedad() {
        return propiedad;
    }

    public void setPropiedad(Propiedad propiedad) {
        this.propiedad = propiedad;
    }

    @Override
    public String toString() {
        return "Foto [id=" + id + 
                ", url=" + url + 
                ", id_propiedad=" + propiedad.getId() + 
                "]";
    }

}
