package com.proyecto.CostaBuses.Model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class Usuariodto
{
    @NotBlank(message = "El nombre no puede venir en blanco")
    private String name;
    @Email(message = "Correo invalido")
    @NotBlank(message = "El correo no puede venir en blanco")
    private String correo;
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&_#.-]).{8,}$",
            message = "La contraseña debe tener mayúsculas, minúsculas, números y caracteres especiales"
    )
    private String password;

    public Usuariodto()
    {

    }

    public Usuariodto(String name, String correo, String password) {
        this.name = name;
        this.correo = correo;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
