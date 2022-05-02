package org.aguzman.patrones.composite.ejemplo;

import org.aguzman.patrones.composite.Archivo;
import org.aguzman.patrones.composite.Directorio;

public class EjemploComposite {
    public static void main(String[] args) {

        Directorio doc = new Directorio("Documentos");
        Directorio java = new Directorio("Java");

        java.addComponente(new Archivo("patron-composite.docx"));
        Directorio stream = new Directorio("Api Stream");
        stream.addComponente(new Archivo("stream-map.docx"));

        java.addComponente(stream);

        doc.addComponente(java);
        doc.addComponente(new Archivo("cv.docx"));
        doc.addComponente(new Archivo("logo.jpeg"));

        System.out.println(doc.mostrar(0));
    }
}
