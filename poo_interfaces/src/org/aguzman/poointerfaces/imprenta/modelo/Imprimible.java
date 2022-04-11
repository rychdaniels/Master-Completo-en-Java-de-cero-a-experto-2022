package org.aguzman.poointerfaces.imprenta.modelo;

public interface Imprimible {

    String TEXTO_DEFECTO = "Imprimiendo un valor por defecto";

    default String imprimir(){
        return TEXTO_DEFECTO;
    }

    static void imprimir(Imprimible imprimible){
        System.out.println(imprimible.imprimir());
    }
}
