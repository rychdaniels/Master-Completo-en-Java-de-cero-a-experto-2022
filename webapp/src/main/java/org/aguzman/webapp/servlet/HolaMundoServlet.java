package org.aguzman.webapp.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;

@WebServlet("/hola-mundo")
public class HolaMundoServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServerException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("     <head>");
        out.println("     <meta charset=\"UTF-8\">");
        out.println("     <title>Hola Mundo Servlet</title>");
        out.println("     </head>");
        out.println("     <body>");
        out.println("         <h1>Hola mundo Servelt!</h1>");
        out.println("     </body>");
        out.println("</html>");
        out.close();
    }
}
