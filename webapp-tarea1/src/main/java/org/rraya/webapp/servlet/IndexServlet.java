package org.rraya.webapp.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        DateFormat df = new SimpleDateFormat("dd 'de' MMMM, yyyy");
        String fechaActual = df.format(new Date());


        String nombre = req.getParameter("nombre");
        String apellido = req.getParameter("apellido");

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("    <head>");
        out.println("        <meta charset=\"UTF-8\">");
        out.println("        <title>Parámetros Get de la url</title>");
        out.println("    </head>");
        out.println("    <body>");
        out.println("        <h1>Parámetros Get de la url!</h1>");
        if (nombre != null) {
            out.println("        <h2>Hola mi nombre es " + nombre + " " + apellido + "</h2>");
        } else {
            out.println("<h2>no se han pasado los parámetros saludos ni nombre</h2>");
        }

        if(fechaActual != null){
            out.println("fechaActual = " + fechaActual);
        }

        out.println("    </body>");
        out.println("</html>");
        out.close();


    }
}
