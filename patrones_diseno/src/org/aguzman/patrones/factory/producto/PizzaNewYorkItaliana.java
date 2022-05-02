package org.aguzman.patrones.factory.producto;

import org.aguzman.patrones.factory.PizzaProducto;

public class PizzaNewYorkItaliana extends PizzaProducto {
    public PizzaNewYorkItaliana() {
        super();
        nombre = "Pizza Italiana New York";
        masa = "Masa gruesa";
        salsa = "Salsa de tomate italiano carne";
        ingredientes.add("Queso Mozzarella");
        ingredientes.add("Aceitunas");
        ingredientes.add("Jamón");
        ingredientes.add("Choricillo");
        ingredientes.add("Champiñones");
    }

    @Override
    public void cocinar() {
        System.out.println("Cocinando por 30 min a 120ºC");
    }

    @Override
    public void cortar() {
        System.out.println("Cortando la pizza en triángulos grandes");
    }
}
