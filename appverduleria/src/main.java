import org.rraya.verduleria.dominio.*;

public class main {
    public static void main(String[] args) {
        Producto listaProductos[] = new Producto[8];

        listaProductos[0] = new Lacteo("Leche", 25.0, 3, 25);
        listaProductos[1] = new Lacteo("Queso", 32.50, 3, 35);
        listaProductos[2] = new Fruta("Melón", 1.2, 4.5, "Verde");
        listaProductos[3] = new Fruta("Sandía", 40.5, 10.2, "Rojo");
        listaProductos[4] = new Limpieza("Cloro", 14.5, "Cloro", 5.4);
        listaProductos[5] = new Limpieza("Pinol", 23.5, "Aroma", 12.3);
        listaProductos[6] = new NoPerecible("Frijoles en lata", 15.5, 15, 20);
        listaProductos[7] =new NoPerecible("Duraznos en almíbar", 23.5, 23, 34);

        for (Producto prod: listaProductos){
            System.out.println(prod.toString());
        }

    }
}
