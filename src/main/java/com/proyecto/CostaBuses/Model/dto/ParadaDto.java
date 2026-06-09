package com.proyecto.CostaBuses.Model.dto;

import jakarta.validation.constraints.NotBlank;

public class ParadaDto
{

    @NotBlank(message = "El nombre no puede quedar en blanco")
    private String nombre;
    @NotBlank(message = "La ubicacion no puede quedar en blanco")
    private String Ubicacion;

    public ParadaDto() {
    }

    public ParadaDto(String nombre, String ubicacion) {
        this.nombre = nombre;
        Ubicacion = ubicacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return Ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        Ubicacion = ubicacion;
    }
}
