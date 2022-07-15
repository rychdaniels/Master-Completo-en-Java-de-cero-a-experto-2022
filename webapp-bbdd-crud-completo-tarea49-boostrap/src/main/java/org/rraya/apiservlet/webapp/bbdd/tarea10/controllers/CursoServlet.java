package org.rraya.apiservlet.webapp.bbdd.tarea10.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.rraya.apiservlet.webapp.bbdd.tarea10.modelos.Curso;
import org.rraya.apiservlet.webapp.bbdd.tarea10.servicios.CursoService;
import org.rraya.apiservlet.webapp.bbdd.tarea10.servicios.CursoServiceImpl;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet("/cursos")
public class CursoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = (Connection) req.getAttribute("conn");

        CursoService serviceCursos = new CursoServiceImpl(conn);
        List<Curso> cursos = serviceCursos.listar();

        req.setAttribute("titulo", "Tarea 49: Crud completo con bootstrap");
        req.setAttribute("cursos", cursos);
        req.setAttribute("title", req.getAttribute("title") + ": Listado Curso");
        getServletContext().getRequestDispatcher("/listar.jsp").forward(req, resp);


    }
}
