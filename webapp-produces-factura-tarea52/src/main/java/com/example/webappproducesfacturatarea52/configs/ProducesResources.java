package com.example.webappproducesfacturatarea52.configs;

import com.example.webappproducesfacturatarea52.models.LineaFactura;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ProducesResources {

    @Produces
    public List<LineaFactura> crearFactura(){
        List<LineaFactura> lineaFacturas = new ArrayList<>();

        lineaFacturas.add(new LineaFactura(23, 3, "Goma para borrar"));
        lineaFacturas.add(new LineaFactura(50, 4, "Lapicera"));
        lineaFacturas.add(new LineaFactura(20000, 1, "Laptop Huawei"));
        lineaFacturas.add(new LineaFactura(560, 1, "Mochila escolar mediana"));
        lineaFacturas.add(new LineaFactura(200, 1, "Calculadora"));

        return lineaFacturas;
    }
}
