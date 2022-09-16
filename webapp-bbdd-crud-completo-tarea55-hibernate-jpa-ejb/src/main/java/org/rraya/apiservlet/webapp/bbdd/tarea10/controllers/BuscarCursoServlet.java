package org.rraya.apiservlet.webapp.bbdd.tarea10.controllers;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.rraya.apiservlet.webapp.bbdd.tarea10.modelos.entities.Curso;
import org.rraya.apiservlet.webapp.bbdd.tarea10.servicios.CursoService;

import java.io.IOException;
import java.util.List;

@WebServlet("/cursos/buscar")
public class BuscarCursoServlet extends HttpServlet {

    @Inject
    CursoService cursoService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Connection conn = (Connection) req.getAttribute("conn");
        String nombreCurso = req.getParameter("nombre");
        //CursoService cursoService = new CursoServiceImpl(conn);

        List<Curso> cursos = null;

        cursos = cursoService.porNombre(nombreCurso);


        req.setAttribute("titulo", "Tarea 9: Listado de cursos");
        req.setAttribute("cursos", cursos);
        getServletContext().getRequestDispatcher("/listar.jsp").forward(req,resp);

    }
}
