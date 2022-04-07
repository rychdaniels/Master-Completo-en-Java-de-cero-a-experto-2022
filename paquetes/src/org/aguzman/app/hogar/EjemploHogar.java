package org.aguzman.app.hogar;

import org.aguzman.app.jardin.Perro;

import static org.aguzman.app.hogar.Persona.saludar;

public class EjemploHogar {
    public static void main(String[] args) {
        Persona p = new Persona();
        Perro perro = new Perro();
        String saludo = saludar();
    }
}
