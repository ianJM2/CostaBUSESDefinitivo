package com.proyecto.CostaBuses.Model.dto;

import jakarta.validation.constraints.NotBlank;

public class RutaDto
{
    @NotBlank(message = "El codigo no puede quedar vacio")
    private String codigo;
    @NotBlank(message = "El origen no puede quedar vacio")
    private String origen;
    @NotBlank(message = "El destino no puede quedar vacio")
    private String destino;



    public RutaDto()
    {

    }

    public RutaDto(String codigo, String origen, String destino) {
        this.codigo = codigo;
        this.origen = origen;
        this.destino = destino;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }
}
