package org.aguzman.recursividad.ejemplo.models;

import java.util.ArrayList;
import java.util.List;

public class Componente {
    private String nombre;
    private List<Componente> hijos;
    private int nivel;

    public Componente(String nombre) {
        this.nombre = nombre;
        this.hijos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Componente> getHijos() {
        return hijos;
    }

    public void setHijos(List<Componente> hijos) {
        this.hijos = hijos;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public Componente addComponente(Componente c){
        this.hijos.add(c);
        return this;
    }

    public boolean tieneHijos(){
        return !this.hijos.isEmpty();
    }
}
