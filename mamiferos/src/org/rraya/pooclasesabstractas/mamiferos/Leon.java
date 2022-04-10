package org.rraya.pooclasesabstractas.mamiferos;

public class Leon extends Felino{
    private Integer numManada;
    private Float potenciaRugidoDecibel;

    public Leon(String habitat, Float altura, Float largo, Float peso, String nombreCientifico, Float tamanioGarras, Integer velocidad, Integer numManada, Float potenciaRugidoDecibel) {
        super(habitat, altura, largo, peso, nombreCientifico, tamanioGarras, velocidad);
        this.numManada = numManada;
        this.potenciaRugidoDecibel = potenciaRugidoDecibel;
    }

    public Integer getNumManada() {
        return numManada;
    }

    public Float getPotenciaRugidoDecibel() {
        return potenciaRugidoDecibel;
    }

    @Override
    public String comer() {
        return "El León se alimenta principalmente animales de mediano y gran tamaño como ñúes, impalas. " +
                "Su manada puede ser de " + this.numManada + " integrantes";
    }

    @Override
    public String correr() {
        return "El León puede llegar a correr hata " + velocidad + "km/h";
    }

    @Override
    public String dormir() {
        return "El León pasa la mayoria del tiempo durmiendo en la selva";
    }

    @Override
    public String comunicarse() {
        return "Se comunica por medio de vocalizaciones y su repertorio es amplio; " +
                "las variaciones en la intensidad y la altura de los sonidos. Su rugido alcanza " + this.potenciaRugidoDecibel +
                " decíbeles";
    }
}
