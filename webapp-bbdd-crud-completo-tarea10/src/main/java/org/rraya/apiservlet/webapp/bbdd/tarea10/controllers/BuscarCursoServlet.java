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
import java.sql.SQLException;
import java.util.List;

@WebServlet("/cursos/buscar")
public class BuscarCursoServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = (Connection) req.getAttribute("conn");
        String nombreCurso = req.getParameter("nombre");
        CursoService cursoService = new CursoServiceImpl(conn);

        List<Curso> cursos = null;
        try {
            cursos = cursoService.porNombre(nombreCurso);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        req.setAttribute("titulo", "Tarea 9: Listado de cursos");
        req.setAttribute("cursos", cursos);
        getServletContext().getRequestDispatcher("/listar.jsp").forward(req,resp);

    }
}
