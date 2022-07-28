package com.example.webappproducesfacturatarea52.models;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;

import java.io.Serializable;

@RequestScoped
public class Cliente implements Serializable {

    private String nombre;
    private String email;
    private String apellidos;

    @PostConstruct
    public void inicializar(){
        this.nombre = "Ricardo";
        this.email = "correo@correo.com";
        this.apellidos = "Raya";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
}
