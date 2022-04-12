package org.rraya.supermercado.genericsclass;

import java.util.ArrayList;
import java.util.List;

public class BolsaSuperMercado<T> {
    private List<T> productos;
    private final int maxProductos = 5;

    public BolsaSuperMercado() {
        this.productos = new ArrayList();
    }

    public List<T> getProductos() {
        return this.productos;
    }

    public void addProducto(T objeto){
        if( this.productos.size() <= maxProductos){
            this.productos.add(objeto);
        } else {
            throw new RuntimeException("La bolsa esta llena");
        }
    }
}
