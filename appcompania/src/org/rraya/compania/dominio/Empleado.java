package org.rraya.compania.dominio;

public class Empleado extends Persona {
    private Double remuneracion;
    private int empleadoId;

    public Empleado(String nombre, String apellido, String numeroFiscal, String direccion, Double remuneracion, int empleadoId) {
        super(nombre, apellido, numeroFiscal, direccion);
        this.remuneracion = remuneracion;
        this.empleadoId = empleadoId;
    }

    public Double getRemuneracion() {
        return remuneracion;
    }

    public int getEmpleadoId() {
        return empleadoId;
    }

    public void aumentarRemuneracion(int porcentaje){
        this.remuneracion += this.remuneracion * (porcentaje/100);
    }

    @Override
    public String toString() {
        return super.toString()
                + "remuneracion=" + remuneracion + " "
                + ", empleadoId=" + empleadoId + " ";

    }
}
