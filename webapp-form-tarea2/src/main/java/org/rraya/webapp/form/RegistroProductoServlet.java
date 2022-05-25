package org.rraya.webapp.form;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/crear")
public class RegistroProductoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        Map<String, String> errores = new HashMap<>();
        String nombre = req.getParameter("nombre");
        String fabricante = req.getParameter("fabricante");

        Integer precio = 0;
        try{
            precio = Integer.parseInt(req.getParameter("precio"));
        } catch (NumberFormatException nfe) {
            System.out.println("nfe = " + nfe);
        }

        Integer categoria = null;
        try {
            categoria = Integer.parseInt(req.getParameter("categoria"));
        } catch(NumberFormatException nfe) {
            System.out.println("nfe = " + nfe);
        }

        if( nombre == null || nombre.isBlank() ){
            errores.put("nombre", "El nombre es obligatorio");
        }

        if( fabricante == null || fabricante.isBlank() ){
            errores.put("fabricante", "Debe ingresar un fabricante");
        }

        if( precio == null || precio < 1 ){
            errores.put("precio", "El precio es obligatorio");
        }
        if( categoria == null || categoria < 1 ){
            errores.put("categoria", "La categoria es obligatoria");
        }

        if( errores.isEmpty() ){
            try(PrintWriter out = resp.getWriter()){

                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("    <head>");
                out.println("        <meta charset=\"UTF-8\">");
                out.println("        <title>Parámetros Get de la url</title>");
                out.println("    </head>");
                out.println("    <body>");
                out.println("        <h1>Producto registrado correctamente!</h1>");
                out.println("        <ul>");
                out.println("            <li>Producto: " + nombre + "</li>");
                out.println("            <li>Precio: " + precio + "</li>");
                out.println("            <li>Fabricante: " + fabricante + "</li>");
                out.println("            <li>Categoria id: " + categoria + "</li>");
                out.println("        </ul>");
                out.println("    </body>");
                out.println("</html>");
            }
        } else {
            req.setAttribute("errores", errores);
            getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
        }


    }
}
