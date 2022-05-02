package org.aguzman.patrones.composite;

import java.util.Objects;

abstract public class Componente {
    protected String nombre;

    public Componente(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    abstract public String mostrar(int nivel);
    abstract public boolean buscar(String nombre);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Componente that = (Componente) o;
        return Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }
}
