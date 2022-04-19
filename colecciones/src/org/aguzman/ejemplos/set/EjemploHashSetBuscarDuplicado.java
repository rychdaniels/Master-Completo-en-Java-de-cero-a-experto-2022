package org.aguzman.ejemplos.set;

import java.util.HashSet;
import java.util.Set;

public class EjemploHashSetBuscarDuplicado {
    public static void main(String[] args) {

        String[] peces = {"Corvina", "Lenguado", "Pejerrey", "Robalo", "Atún", "Lenguado"};

        Set<String> unicos = new HashSet<>();
        for(String pez: peces){
            if(!unicos.add(pez)){
                System.out.println("Elemento Duplicado: " + pez);
            }
        }
        System.out.println(unicos.size() + " elementos no duplicados: " + unicos);
    }
}
