package com.proyecto.CostaBuses.Model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class Login
{
    @Email(message = "Correo incorrecto")
    @NotBlank(message = "El correo no puede quedar en blanco")
    private String correo;
    @NotBlank(message = "El password no puede quedar en blanco")
    private String password;

    public Login()
    {
    }

    public Login(String correo, String password) {
        this.correo = correo;
        this.password = password;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String email) {
        this.correo = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
