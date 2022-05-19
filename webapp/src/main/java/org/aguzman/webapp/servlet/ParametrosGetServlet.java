package org.aguzman.webapp.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/parametros/url-get")
public class ParametrosGetServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String saludo = req.getParameter("saludo");
        String nombre = req.getParameter("nombre");

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("    <head>");
        out.println("        <meta charset=\"UTF-8\">");
        out.println("        <title>Parámetros Get de la url</title>");
        out.println("    </head>");
        out.println("    <body>");
        out.println("        <h1>Parámetros Get de la url!</h1>");
        if (saludo != null && nombre != null) {
            out.println("        <h2>El saludo enviado es: " + saludo + " " + nombre + "</h2>");
        } else if (saludo != null) {
            out.println("        <h2>El saludo enviado es: " + saludo + "</h2>");
        } else if (nombre != null) {
            out.println("        <h2>Hola mi nombre es " + nombre + "</h2>");
        } else {
            out.println("<h2>no se han pasado los parámetros saludos ni nombre</h2>");
        }

        try {
            int codigo = Integer.parseInt(req.getParameter("codigo"));
            out.println("<h3>El codigo enviado es : " + codigo + "</h3>");
        } catch (NumberFormatException e){
            out.println("<h3>El codigo no se ha enviado, es null</h3>");
        }
        out.println("    </body>");
        out.println("</html>");
        out.close();
    }
}
