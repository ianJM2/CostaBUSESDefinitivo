package com.proyecto.CostaBuses.Model;

import jakarta.persistence.*;

@Entity
@Table(name="tb-Paradas")
public class Parada
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String ubicacion;
    private String seguridad;

    public Parada()
    {

    }

    public Parada(Integer id, String ubicacion, String seguridad) {
        this.id = id;
        this.ubicacion = ubicacion;
        this.seguridad = seguridad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getSeguridad() {
        return seguridad;
    }

    public void setSeguridad(String seguridad) {
        this.seguridad = seguridad;
    }
}
