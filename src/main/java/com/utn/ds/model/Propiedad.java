package com.utn.ds.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "propiedad")
public class Propiedad implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "cod_propiedad")
    private String codPropiedad;
    
    @Column(name = "medidas")
    private String medidas;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "antiguedad")
    private Date antiguedad;
    
    @Column(name = "amueblado")
    private boolean amueblado;
    
    @Column(name = "cant_habitaciones")
    private Integer cantHabitaciones;
    
    @Column(name = "servicios")
    private String servicios;
    
    @Column(name = "descripcion")
    private String descripcion;
    
    @Column(name = "disponibilidad")
    private boolean disponibilidad;
    
    @Column(name = "tipo")
    private String tipo;
    
    @Column(name = "precio")
    private BigDecimal precio;
    
//    @ManyToOne 
//    @JoinColumn(name = "id_tipo_propiedad", nullable = false)
//    private TipoPropiedad tipoPropiedad;
    
    public Propiedad() {

    }

    public Propiedad(String codPropiedad, String medidas, Date antiguedad, boolean amueblado, Integer cantHabitaciones, String servicios, String descripcion, boolean disponibilidad, String tipo, BigDecimal precio) {
        this.codPropiedad = codPropiedad;
        this.medidas = medidas;
        this.antiguedad = antiguedad;
        this.amueblado = amueblado;
        this.cantHabitaciones = cantHabitaciones;
        this.servicios = servicios;
        this.descripcion = descripcion;
        this.disponibilidad = disponibilidad;
        this.tipo = tipo;
        this.precio = precio;
    }
    
    

//    public Propiedad(BigDecimal precio, String descripcion, TipoPropiedad tipoPropiedad) {
//        this.precio = precio;
//        this.descripcion = descripcion;
//        this.tipoPropiedad = tipoPropiedad;
//    }

    public long getId() {
        return id;
    }

    public String getCodPropiedad() {
        return codPropiedad;
    }

    public void setCodPropiedad(String codPropiedad) {
        this.codPropiedad = codPropiedad;
    }

    public String getMedidas() {
        return medidas;
    }

    public void setMedidas(String medidas) {
        this.medidas = medidas;
    }

    public Date getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(Date antiguedad) {
        this.antiguedad = antiguedad;
    }

    public boolean isAmueblado() {
        return amueblado;
    }

    public void setAmueblado(boolean amueblado) {
        this.amueblado = amueblado;
    }

    public Integer getCantHabitaciones() {
        return cantHabitaciones;
    }

    public void setCantHabitaciones(Integer cantHabitaciones) {
        this.cantHabitaciones = cantHabitaciones;
    }

    public String getServicios() {
        return servicios;
    }

    public void setServicios(String servicios) {
        this.servicios = servicios;
    }
    
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }
    
//    public TipoPropiedad getTipoPropiedad() {
//        return this.tipoPropiedad;
//    }
//    
//    public void setTipoPropiedad(TipoPropiedad tipoPropiedad) {
//        this.tipoPropiedad = tipoPropiedad;
//    }

    @Override
    public String toString() {
        return "Propiedad [id=" + id + ", precio=" + precio + ", descripcion=" + descripcion + ", tipo= " + tipo + "]";
    }

}
