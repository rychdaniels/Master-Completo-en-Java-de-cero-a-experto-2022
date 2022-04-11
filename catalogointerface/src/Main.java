import org.rraya.catalogointerface.modelo.*;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        IProducto[] productos = new Producto[6];

        productos[0] = new Comics(500, new Date(), "Stan Lee", "Infinity War", "Sevilla", "Thanos");
        productos[1] = new TvLcd(20000, "Samsung", 65);
        productos[2] = new IPhone(25000, "Apple", "Iphone 12", "Negro espacial");
        productos[3] = new Libro(850, new Date(), "Luis Joyanes", "Introducción a la Programación", "AlfaOmega");
        productos[4] = new TvLcd(23000, "Sony", 60);
        productos[5] = new IPhone(18000, "Apple", "Iphone Pro Max", "Negro");

        System.out.println("============= LISTA DE PRODUCTOS ==================\n");

        for (IProducto producto: productos){
            StringBuilder sb = new StringBuilder();
            sb.append("Producto: " + producto.getClass().getSimpleName() + "\n");
            sb.append("Precio: ")
                    .append(producto.getPrecio())
                    .append("\n")
                    .append("Precio de venta: ")
                    .append(producto.getPrecioVenta())
                    .append("\n");

            if(producto instanceof IElectronico){
                sb.append("Fabricante: ")
                        .append(((Electronico) producto).getFabricante())
                        .append("\n");
                if(producto instanceof IPhone){
                    sb.append("Modelo: ")
                            .append(((IPhone) producto).getModelo())
                            .append("\n")
                            .append("Fabricante: ")
                            .append(((IPhone) producto).getFabricante())
                            .append("\n");
                }
                if (producto instanceof TvLcd){
                    sb.append("Tamaño: ")
                            .append(((TvLcd) producto).getPulgada())
                            .append(" pulgadas\n");
                }
            }


            if(producto instanceof ILibro){
                sb.append("Fecha de publicación: ")
                        .append(((ILibro) producto).getFechaPublicacion())
                        .append("\nAutor: ")
                        .append(((ILibro) producto).getAutor())
                        .append("\nTitulo: ")
                        .append(((ILibro) producto).getTitulo())
                        .append("\nEditorial: ")
                        .append(((ILibro) producto).getEditorial())
                        .append("\n");
                if(producto instanceof Comics){
                    sb.append("Personaje: ")
                            .append(((Comics) producto).getPersonaje())
                            .append("\n");
                }
            }
            sb.append("===================================================");
            System.out.println(sb);
        }

    }
}
