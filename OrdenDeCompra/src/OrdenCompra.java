import java.util.Calendar;
import java.util.Date;

public class OrdenCompra {

    private Integer identificador;
    private int contProductos;
    private String descripcion;
    private Date fecha;
    private Cliente cliente;
    private Producto[] productos;

    private static int ultimoId;

    public OrdenCompra(String descripcion) {
        this.descripcion = descripcion;
        this.identificador = ++ultimoId;
        this.productos = new Producto[4];
    }

    public Integer getIdentificador() {
        return identificador;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Producto[] getProductos() {
        return productos;
    }

    public void addProducto(Producto producto){
        if(this.contProductos < this.productos.length) {
            this.productos[this.contProductos++] = producto;
        }
    }

    public int getTotal(){
        int suma = 0;
        for (int i = 0; i < this.productos.length; i++) {
            if(this.productos[i] != null){
                suma += productos[i].getPrecio();
            }
        }
        return suma;
    }

    public String formatFecha(Date fecha){
        Calendar fechaString = Calendar.getInstance();
        fechaString.setTime(fecha);
        return fechaString.get(Calendar.DAY_OF_MONTH) + "/" + fechaString.get(Calendar.MONTH) + "/" + fechaString.get(Calendar.YEAR);
    }

    public String imprimirCliente(){
        String cliente = "";
        if(this.cliente != null){
            cliente += this.cliente.getNombre() + " " + this.cliente.getApellido();
        }
        return cliente;
    }

    public String imprimirProductos(){
        String productos = "";

        for (int i = 0; i < this.productos.length; i++) {
            if(this.productos[i] != null)
                productos += (i + 1) + ": " + this.productos[i].getFabricante() + " " + this.productos[i].getNombre() + "\n";
        }
        return productos == "" ? "No hay productos" : productos;
    }

    public String imprimirDetalleOrden(){
        String detalle = "Orden: " + this.identificador;
        if(this.getFecha() != null){
            detalle += "\nFecha: " + this.formatFecha(this.getFecha());
        }

        if(this.cliente != null){
            detalle += "\nCliente: " + imprimirCliente();
        }

        detalle += "\nDescripción: " + this.descripcion
        + "\nProductos:\n"  + this.imprimirProductos();

        int total = this.getTotal();
        if(total != 0){
            detalle += "Total: $" + total + ".00 MXN\n";
        }

         return detalle;
    }
}
