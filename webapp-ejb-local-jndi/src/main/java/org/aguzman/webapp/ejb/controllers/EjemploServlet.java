package org.aguzman.webapp.ejb.controllers;

import jakarta.ejb.EJB;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.aguzman.webapp.ejb.models.Producto;
import org.aguzman.webapp.ejb.service.ServiceEjb;
import org.aguzman.webapp.ejb.service.ServiceEjbLocal;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.IOException;

@WebServlet("/index")
public class EjemploServlet extends HttpServlet {

    //@Inject
    //private ServiceEjbLocal service;

    //@Inject
    //private ServiceEjbLocal service2;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServiceEjbLocal service = null;
        ServiceEjbLocal service2 = null;
        try {
            InitialContext ctx = new InitialContext();
            service = (ServiceEjbLocal) ctx.lookup("java:global/webapp-ejb/ServiceEjb!org.aguzman.webapp.ejb.service.ServiceEjbLocal");
            service2 = (ServiceEjbLocal) ctx.lookup("java:global/webapp-ejb/ServiceEjb!org.aguzman.webapp.ejb.service.ServiceEjbLocal");
        } catch (NamingException e) {
            e.printStackTrace();
        }
        System.out.println("service si es igual a service2 = " + service.equals(service2));

        Producto  p = service.crear(new Producto("uvas"));
        System.out.println("nuevo producto " + p);

        req.setAttribute("saludo", service.saludar("Andres"));
        req.setAttribute("saludo2", service2.saludar("John"));
        req.setAttribute("listado", service.listar());
        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
