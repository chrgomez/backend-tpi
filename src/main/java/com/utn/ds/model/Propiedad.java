package com.utn.ds.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "propiedad")
public class Propiedad implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "precio")
    private String precio;

    @Column(name = "descripcion")
    private String descripcion;
    
    @ManyToOne 
    @JoinColumn(name = "id_tipo_propiedad", nullable = false)
    private TipoPropiedad tipoPropiedad;
    
    public Propiedad() {

    }

    public Propiedad(String precio, String descripcion, TipoPropiedad tipoPropiedad) {
        this.precio = precio;
        this.descripcion = descripcion;
        this.tipoPropiedad = tipoPropiedad;
    }

    public long getId() {
        return id;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public TipoPropiedad getTipoPropiedad() {
        return this.tipoPropiedad;
    }
    
    public void setTipoPropiedad(TipoPropiedad tipoPropiedad) {
        this.tipoPropiedad = tipoPropiedad;
    }

    @Override
    public String toString() {
        return "Propiedad [id=" + id + ", precio=" + precio + ", descripcion=" + descripcion + ", tipoPropiedad= " + tipoPropiedad.getNombre() + "]";
    }

}
