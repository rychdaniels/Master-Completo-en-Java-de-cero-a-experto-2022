package org.rraya.pooclasesabstractas.mamiferos;

public class Lobo extends Canino{

    private Integer numCamada;
    private String especieLobo;

    public Lobo(String habitat, Float altura, Float largo, Float peso, String nombreCientifico, String color, Float tamanioColmillos, Integer numCamada, String especieLobo) {
        super(habitat, altura, largo, peso, nombreCientifico, color, tamanioColmillos);
        this.numCamada = numCamada;
        this.especieLobo = especieLobo;
    }

    public Integer getNumCamada() {
        return numCamada;
    }

    public String getEspecieLobo() {
        return especieLobo;
    }

    @Override
    public String comer() {
        return "El Lobo " + this.especieLobo + " se alimenta de alces, mulas y el venado cola blanca, etc.";
    }

    @Override
    public String dormir() {
        return "El sueño del Lobo es intermitente. Habitan en toda Eurasia y América del Norte, y han sido introducidos en Australia";
    }

    @Override
    public String correr() {
        return "El Lobo puede llegar a correr entre 50 y 60 km/h";
    }

    @Override
    public String comunicarse() {
        return "Los Lobos se comunican por medio de aullidos";
    }
}
