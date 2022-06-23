package org.aguzman.apiservlet.webapp.headers.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Carro {
    private List<ItemCarro> items;

    public Carro() {
        this.items = new ArrayList<>();
    }

    public void addItemCarro(ItemCarro itemCarro) {
        if (items.contains(itemCarro)) {
            Optional<ItemCarro> optionalItemCarro = items.stream()
                    .filter(i -> i.equals(itemCarro))
                    .findAny();
            if (optionalItemCarro.isPresent()) {
                ItemCarro i = optionalItemCarro.get();
                i.setCantidad(i.getCantidad()+1);
            }
        } else {
            this.items.add(itemCarro);
        }
    }
    public List<ItemCarro> getItems() {
        return items;
    }

    public int getTotal() {
        return items.stream().mapToInt(ItemCarro::getImporte).sum();
    }

    public void deleteItemsCarro(List<String> productoIds) {
        productoIds.forEach( idProducto -> eliminaProducto(idProducto));
    }

    public void eliminaProducto(String idProducto){

        Optional<ItemCarro> producto = items
                .stream()
                .filter( idProd -> idProducto.equals(Long.toString(idProd.getProducto().getId())))
                .findAny();

        producto.ifPresent(itemCarro -> items.remove(itemCarro));
    }

    public void updateCantidad(String productoId, int cantidad) {
        Optional<ItemCarro> producto = items
                .stream()
                .filter( idProd -> productoId.equals(Long.toString(idProd.getProducto().getId())))
                .findAny();
        producto.ifPresent(itemCarro -> itemCarro.setCantidad(cantidad));
    }
}
