package org.rraya.pooclasesabstractas.mamiferos;

public class Perro extends Canino{
    private Integer fuerzaMordida;

    public Perro(String habitat, Float altura, Float largo, Float peso, String nombreCientifico, String color, Float tamanioColmillos, Integer fuerzaMordida) {
        super(habitat, altura, largo, peso, nombreCientifico, color, tamanioColmillos);
        this.fuerzaMordida = fuerzaMordida;
    }

    public Integer getFuerzaMordida() {
        return fuerzaMordida;
    }

    @Override
    public String comer() {
        return "El perro es una especie domestica se alimenta generalmente de croquetas";
    }

    @Override
    public String dormir() {
        return "Los perros pueden llegar a dormir 6hrs.";
    }

    @Override
    public String correr() {
        return "El perro puede llegar a correr entre 48 y 72 km/h";
    }

    @Override
    public String comunicarse() {
        return "Los perros se comunican por medio de ladridos o aullidos";
    }
}
