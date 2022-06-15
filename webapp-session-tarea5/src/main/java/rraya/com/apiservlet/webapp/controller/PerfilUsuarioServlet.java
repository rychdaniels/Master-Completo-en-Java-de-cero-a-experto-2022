package rraya.com.apiservlet.webapp.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

@WebServlet("/perfil-usuario")
public class PerfilUsuarioServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String nombre = "Sin nombre";
        if (req.getSession().getAttribute("nombre") != null) {
            resp.setContentType("text/html;charset=UTF-8");
            nombre = req.getSession().getAttribute("nombre").toString();
            try (PrintWriter out = resp.getWriter()) {

                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("    <head>");
                out.println("        <meta charset=\"UTF-8\">");
                out.println("        <title>Perfil Usuario</title>");
                out.println("    </head>");
                out.println("    <body>");
                out.println("        <h1>Hola " + nombre + " has iniciado sesión con éxito!</h1>");
                out.println("<p><a href='" + req.getContextPath() + "/index.jsp'>volver</a></p>");
                out.println("    </body>");
                out.println("</html>");
            }
        }
    }
}
