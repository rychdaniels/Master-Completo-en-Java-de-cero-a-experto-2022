package org.rraya.stream.api.modelo;

public class Producto {

    private int cantidad;
    private double precio;

    public Producto(int cantidad, double precio) {
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecio() {
        return precio;
    }
}
