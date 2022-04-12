package org.rraya.supermercado;

import org.rraya.supermercado.genericsclass.BolsaSuperMercado;
import org.rraya.supermercado.modelo.Fruta;
import org.rraya.supermercado.modelo.Lacteo;
import org.rraya.supermercado.modelo.Limpieza;
import org.rraya.supermercado.modelo.NoPerecible;

public class Main {
    public static void main(String[] args) {

        BolsaSuperMercado<Lacteo> bolsaLacteos = new BolsaSuperMercado<>();
        BolsaSuperMercado<Fruta>  bolsaFrutas = new BolsaSuperMercado<>();
        BolsaSuperMercado<Limpieza> bolsaLimpieza = new BolsaSuperMercado<>();
        BolsaSuperMercado<NoPerecible> bolsaNoPerecibles = new BolsaSuperMercado<>();

        bolsaLacteos.addProducto(new Lacteo("Leche", 23.60, 3, 2));
        bolsaLacteos.addProducto(new Lacteo("Leche Deslactosada", 26.60, 1, 3));
        bolsaLacteos.addProducto(new Lacteo("Queso Dbole Crema", 30.50, 1, 2));

        bolsaFrutas.addProducto(new Fruta("Melón", 30.50, 3.4, "Naranja"));
        bolsaFrutas.addProducto(new Fruta("Naranja", 10.30, 5.4, "Naranja"));
        bolsaFrutas.addProducto(new Fruta("Sandia", 34.20, 13.4, "Rojo"));
        bolsaFrutas.addProducto(new Fruta("Pera", 22.50, 1.4, "Verde"));
        bolsaFrutas.addProducto(new Fruta("Mandarina", 2.50, 3.4, "Naranja"));
        bolsaFrutas.addProducto(new Fruta("Mango", 23.50, 3.4, "Amarillo"));

        bolsaLimpieza.addProducto(new Limpieza("Pinol", 15.60, "Jabón", 2.0));
        bolsaLimpieza.addProducto(new Limpieza("Fabuloso", 12.30, "Aromatizante", 1.0));
        bolsaLimpieza.addProducto(new Limpieza("Vel Rosita", 25.40, "Blaqueador", 2.0));

        bolsaNoPerecibles.addProducto(new NoPerecible("Frijol enlatado", 15.60, 480, 30));
        bolsaNoPerecibles.addProducto(new NoPerecible("Atún enlatado", 25.30, 230, 20));
        bolsaNoPerecibles.addProducto(new NoPerecible("Frijol en bolsa", 12.20, 480, 34));
        bolsaNoPerecibles.addProducto(new NoPerecible("Lentejas enlatadas", 12.60, 340, 43));


        System.out.println("===== Bolsa de Lacteos =====");
        for (Lacteo bLacteo: bolsaLacteos.getProductos()) {
            System.out.println("Nombre: " + bLacteo.getNombre());
            System.out.println("Proteinas: " + bLacteo.getProteinas() + " grs.");
            System.out.println("Precio: $" + bLacteo.getPrecio());
            System.out.println();
        }

        System.out.println("===== Bolsa de Frutas =====");
        for (Fruta fruta: bolsaFrutas.getProductos()) {
            System.out.println("Nombre: " + fruta.getNombre());
            System.out.println("Color: " + fruta.getColor());
            System.out.println("Peso: $" + fruta.getPeso() + "kg.");
            System.out.println();
        }

        System.out.println("===== Bolsa de Articulos de Limpieza =====");
        for (Limpieza articulo: bolsaLimpieza.getProductos()) {
            System.out.println("Nombre: " + articulo.getNombre());
            System.out.println("Presntacion: " + articulo.getLitros() + " litros");
            System.out.println("Componentes: " + articulo.getComponentes());
            System.out.println("Precio: $" + articulo.getPrecio());
            System.out.println();
        }

        System.out.println("===== Bolsa de Articulos no Perecederos =====");
        for (NoPerecible articulo: bolsaNoPerecibles.getProductos()) {
            System.out.println("Nombre: " + articulo.getNombre());
            System.out.println("Contenido neto: " + articulo.getContenido() + " grs.");
            System.out.println("Calorias: " + articulo.getCalorias() + " calorias");
            System.out.println("Precio: $" + articulo.getPrecio());
            System.out.println();
        }


    }
}
