package com.proyecto.CostaBuses.Model.dto;

import jakarta.validation.constraints.NotBlank;

public class BusDto
{

    @NotBlank(message = "El Bus no puede estar sin placa")
    private String placa;
    @NotBlank(message = "No se pueden utilizar buses de modelos indefinidos")
    private String modelo;
    @NotBlank(message = "La capacidad debe estar definida")
    private Integer capacidad;
    @NotBlank(message = "necesitamos un conductor")
    private String conductor;
    private String codigoDeRuta;

    public BusDto() {
    }

    public BusDto(String placa, String modelo, Integer capacidad, String conductor, String codigoDeRuta) {
        this.placa = placa;
        this.modelo = modelo;
        this.capacidad = capacidad;
        this.conductor = conductor;
        this.codigoDeRuta = codigoDeRuta;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public String getConductor() {
        return conductor;
    }

    public void setConductor(String conductor) {
        this.conductor = conductor;
    }

    public String getCodigoDeRuta() {
        return codigoDeRuta;
    }

    public void setCodigoDeRuta(String codigoDeRuta) {
        this.codigoDeRuta = codigoDeRuta;
    }
}
