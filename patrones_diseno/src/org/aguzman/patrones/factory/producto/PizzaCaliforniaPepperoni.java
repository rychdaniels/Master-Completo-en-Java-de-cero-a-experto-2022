package org.aguzman.patrones.factory.producto;

import org.aguzman.patrones.factory.PizzaProducto;

public class PizzaCaliforniaPepperoni extends PizzaProducto {
    public PizzaCaliforniaPepperoni() {
        super();
        nombre = "Pizza California Pepperoni";
        masa = "Masa a la piedra gruesa";
        ingredientes.add("Pepperoni");
        ingredientes.add("Extra queso mozzarella");
        ingredientes.add("Aceitunas");

    }

    @Override
    public void cocinar() {
        System.out.println("Cocinando a 50 min. a 55ºC");
    }

    @Override
    public void cortar() {
        System.out.println("Cortando la pizza en pequeños rectángulos");
    }
}
