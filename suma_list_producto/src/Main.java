import org.rraya.stream.api.modelo.Producto;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Producto> productos = new ArrayList<>();

        productos.add(new Producto(3, 13.60));
        productos.add(new Producto(2, 9.20));
        productos.add(new Producto(3, 13.40));

        /* Forma larga **/
        /*double resultado = productos.stream()
                .map( producto -> producto.getCantidad() * producto.getPrecio())
                .reduce(Double.valueOf(0), (a, b) -> a + b);*/

        double resultado = productos.stream()
                .map( producto -> producto.getCantidad() * producto.getPrecio())
                .reduce(Double.valueOf(0), Double::sum);


        System.out.println("resultado = " + resultado);
    }
}
