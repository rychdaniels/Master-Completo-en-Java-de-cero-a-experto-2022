package com.example.webappproducesfacturatarea52.models;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.List;

@RequestScoped
@Named
public class Factura {

    @Inject
    List<LineaFactura> lineaFacturas;

    @Inject
    Cliente cliente;

    Integer numeroFactura;
    String descripcion;
    Integer importeTotal;


    @PostConstruct
    public void inicializar(){
        this.numeroFactura = 2367;
        this.descripcion = "Factura de prueba";
        setImporteTotal(calculaImporteTotal());

    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Integer getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(Integer numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<LineaFactura> getLineaFacturas() {
        return lineaFacturas;
    }


    public void setLineaFacturas(List<LineaFactura> lineaFacturas) {
        this.lineaFacturas = lineaFacturas;
    }

    public Integer getImporteTotal() {
        return importeTotal;
    }

    public void setImporteTotal(Integer importeTotal) {
        this.importeTotal = importeTotal;
    }

    public int calculaImporteTotal() {
        int importeTotal = 0;
        for (LineaFactura lineaFacturas: lineaFacturas) {
            importeTotal += lineaFacturas.getImportePorArticulo();
        }
        return importeTotal;
    }

}
