package org.rraya.apiservlet.webapp.bbdd.tarea9.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.rraya.apiservlet.webapp.bbdd.tarea9.modelos.Curso;
import org.rraya.apiservlet.webapp.bbdd.tarea9.servicios.CursoService;
import org.rraya.apiservlet.webapp.bbdd.tarea9.servicios.CursoServiceImpl;

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

        req.setAttribute("titulo", "Tarea 9: Listado de cursos");
        req.setAttribute("cursos", cursos);
        getServletContext().getRequestDispatcher("/listar.jsp").forward(req, resp);


    }
}
