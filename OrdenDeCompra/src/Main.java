import java.util.Date;

public class Main {
    public static void main(String[] args) {

        Producto producto1 = new Producto("Apple", "Iphone", 10000);
        Producto producto2 = new Producto("Huawei", "P40", 25000);
        Producto producto3 = new Producto("Samsung", "A52", 14000);
        Producto producto4 = new Producto("Xiaomi", "Note 10s", 7000);
        Producto producto5 = new Producto("Motorola", "G9 Plus", 5000);
        Producto producto6 = new Producto("Xiaomi", "Note 11 Pro", 17000);
        Producto producto7 = new Producto("Lenovo", "Tablet Idea Pad", 3500);
        Producto producto8 = new Producto("HP", "Elite Book", 27000);
        Producto producto9 = new Producto("Asus", "Monitor-H2304", 4000);
        Producto producto10 = new Producto("Samsung", "Tablet-S6", 12000);


        OrdenCompra orden1 = new OrdenCompra("Primera orden de compra");
        orden1.setFecha(new Date());
        orden1.setCliente(new Cliente("Clark", "Kent"));
        orden1.addProducto(producto4);
        orden1.addProducto(producto3);
        orden1.addProducto(producto8);
        orden1.addProducto(producto10);
        System.out.println(orden1.imprimirDetalleOrden());
        System.out.println("********************---------------------------------************************");
        OrdenCompra orden2 = new OrdenCompra("Segunda orden de compra");
        orden2.setFecha(new Date());
        orden2.setCliente(new Cliente("Jesús", "Lopez"));
        orden2.addProducto(producto8);
        orden2.addProducto(producto1);
        orden2.addProducto(producto6);
        System.out.println(orden2.imprimirDetalleOrden());
        System.out.println("********************---------------------------------************************");

        OrdenCompra orden3 = new OrdenCompra("Tercera orden de compra");
        orden3.setFecha(new Date());
        orden3.setCliente(new Cliente("Luisa", "Lane"));
        orden3.addProducto(producto2);
        orden3.addProducto(producto5);
        orden3.addProducto(producto7);
        orden3.addProducto(producto8);
        orden3.addProducto(producto9);
        System.out.println(orden3.imprimirDetalleOrden());

    }
}
