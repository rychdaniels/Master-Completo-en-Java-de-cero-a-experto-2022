package com.example.webappproducesfacturatarea52.controllers;

import com.example.webappproducesfacturatarea52.models.Factura;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet({"/factura", "/"})
public class FacturaController extends HttpServlet {

    @Inject
    private Factura factura;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("factura", factura);
        req.setAttribute("title", "Ejemplo de factura con inyeccion de dependencias");

        getServletContext().getRequestDispatcher("/factura.jsp").forward(req, resp);
    }
}
