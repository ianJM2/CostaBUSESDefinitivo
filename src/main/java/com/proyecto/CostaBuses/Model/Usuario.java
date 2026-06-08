package com.proyecto.CostaBuses.Model;


import jakarta.persistence.*;

@Entity
@Table(name="tb-usuarios")
public class Usuario
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String correo;
    private String password;

    public Usuario()
    {

    }

    public Usuario(Integer id, String name, String correo, String password)
    {
        this.id = id;
        this.name = name;
        this.correo = correo;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
