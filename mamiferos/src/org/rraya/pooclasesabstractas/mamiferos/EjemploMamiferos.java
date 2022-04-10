package org.rraya.pooclasesabstractas.mamiferos;

public class EjemploMamiferos {

    public static void main(String[] args) {
        Mamifero[] mamiferos = new Mamifero[6];

        Mamifero tigre = new Tigre("Jungla", 1.15f, 2.0f, 180.5f, "Panthera tigris", 13.6f, 60, "Blamco");
        Mamifero leon = new Leon("Selva", 1.20f, 2.0f, 200.5f, "Panthera leo", 60.5f, 5, 10, 200f);
        Mamifero guepardo = new Guepardo("África", 1.80f, 1.40f, 140.6f, "Acinonyx jubatus", 8.9f, 80);
        Mamifero lobo = new Lobo("Chihuahua", 1.80f, 1.40f, 80.5f, "Canis lupus", "Gris", 7.8f, 10, "Mexicano");
        Mamifero perro = new Perro("Variado", 1.68f, 1.30f, 40.6f, "Canis lupus familiaris", "Amarillo", 3.4f, 80);

        mamiferos[0] = tigre;
        mamiferos[1] = leon;
        mamiferos[2] = guepardo;
        mamiferos[3] = lobo;
        mamiferos[4] = perro;

        for (Mamifero mamifero: mamiferos){
            if (mamifero != null){
                StringBuilder sb = new StringBuilder();
                sb.append("=============================\n")
                    .append(mamifero.comer())
                    .append("\n")
                    .append(mamifero.comunicarse())
                    .append("\n")
                    .append(mamifero.correr())
                    .append("\n")
                    .append(mamifero.dormir())
                    .append("\n=============================\n");
                System.out.println(sb);
            }
        }

    }

}
