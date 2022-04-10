package org.rraya.pooclasesabstractas.mamiferos;

public class Canino extends Mamifero{

    protected String color;
    protected Float tamanioColmillos;

    public Canino(String habitat, Float altura, Float largo, Float peso, String nombreCientifico, String color, Float tamanioColmillos) {
        super(habitat, altura, largo, peso, nombreCientifico);
        this.color = color;
        this.tamanioColmillos = tamanioColmillos;
    }

    public String getColor() {
        return color;
    }

    public Float getTamanioColmillos() {
        return tamanioColmillos;
    }

    @Override
    public String comer() {
        return null;
    }

    @Override
    public String dormir() {
        return null;
    }

    @Override
    public String correr() {
        return null;
    }

    @Override
    public String comunicarse() {
        return null;
    }
}
