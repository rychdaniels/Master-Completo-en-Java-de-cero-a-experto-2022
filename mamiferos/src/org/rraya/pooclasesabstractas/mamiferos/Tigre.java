package org.rraya.pooclasesabstractas.mamiferos;

public class Tigre extends Felino{
    private String especieTigre;

    public Tigre(String habitat, Float altura, Float largo, Float peso, String nombreCientifico, Float tamanioGarras, Integer velocidad, String especieTigre) {
        super(habitat, altura, largo, peso, nombreCientifico, tamanioGarras, velocidad);
        this.especieTigre = especieTigre;
    }

    public String getEspecieTigre() {
        return especieTigre;
    }

    @Override
    public String comer() {
        return "El Tigre " + this.especieTigre + " no caza en manada es una especie solitaria y es carnívoro";
    }

    @Override
    public String dormir() {
        return "El Tigre pasa durmiendo casi 16 horas diarias";
    }

    @Override
    public String correr() {
        return "El Tigre puede correr a gran velocidad, corre a " + velocidad + " km/h";
    }

    @Override
    public String comunicarse() {
        return "El Tigre se comunica por medio de vocalizaciones, tales como ronroneos y gruñidos";
    }
}
