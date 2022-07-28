package com.example.webappproducesfacturatarea52.models;

import jakarta.enterprise.context.RequestScoped;

@RequestScoped
public class LineaFactura {

    Integer precio;
    Integer cantidad;
    String nombreProducto;
    Integer importePorArticulo;

    public LineaFactura(Integer precio, Integer cantidad, String nombreProducto) {
        this.precio = precio;
        this.cantidad = cantidad;
        this.nombreProducto = nombreProducto;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Integer getImportePorArticulo() { return this.cantidad * this.precio;}

}
