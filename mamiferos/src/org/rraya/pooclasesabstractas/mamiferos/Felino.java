package org.rraya.pooclasesabstractas.mamiferos;

public class Felino extends Mamifero{

    protected Float tamanioGarras;
    protected Integer velocidad;

    public Felino(String habitat, Float altura, Float largo, Float peso, String nombreCientifico, Float tamanioGarras, Integer velocidad) {
        super(habitat, altura, largo, peso, nombreCientifico);
        this.tamanioGarras = tamanioGarras;
        this.velocidad = velocidad;
    }

    public Float getTamanioGarras() {
        return tamanioGarras;
    }

    public Integer getVelocidad() {
        return velocidad;
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
