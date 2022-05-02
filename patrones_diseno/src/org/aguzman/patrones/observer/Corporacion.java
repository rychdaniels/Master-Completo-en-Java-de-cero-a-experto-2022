package org.aguzman.patrones.observer;

public class Corporacion extends Observable {
    private String nombre;
    private int precio;

    public Corporacion(String nombre, int precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void modificaPrecio(int precio){
        this.precio = precio;
        notifyObservers();
    }

    @Override
    public String toString() {
        return getNombre() +
                " nuevo precio $" +
                getPrecio();
    }
}
