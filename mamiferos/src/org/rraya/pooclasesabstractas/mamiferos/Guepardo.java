package org.rraya.pooclasesabstractas.mamiferos;

public class Guepardo extends Felino{

    public Guepardo(String habitat, Float altura, Float largo, Float peso, String nombreCientifico, Float tamanioGarras, Integer velocidad) {
        super(habitat, altura, largo, peso, nombreCientifico, tamanioGarras, velocidad);
    }

    @Override
    public String comer() {
        return "El Guepardo se alimenta de presas pequeñas, algunas de sus presas más habituales son los antílopes, gacelas";
    }

    @Override
    public String dormir() {
        return "El Guepardo puede llegar adormr 13 horas, se encuentra en África";
    }

    @Override
    public String correr() {
        return "El Guepardo puede correr a " + velocidad + " km/h";
    }

    @Override
    public String comunicarse() {
        return "El Guperado se comunica por medio de vocalizaciones";
    }
}
