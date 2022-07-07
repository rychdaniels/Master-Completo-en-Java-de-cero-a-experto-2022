package org.rraya.apiservlet.webapp.bbdd.tarea10.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.rraya.apiservlet.webapp.bbdd.tarea10.servicios.CursoService;
import org.rraya.apiservlet.webapp.bbdd.tarea10.servicios.CursoServiceImpl;

import java.io.IOException;
import java.sql.Connection;

@WebServlet("/cursos/eliminar")
public class CursoEliminarServlet extends HttpServlet {

    //7		Andres Guzman	15.12 hrs.
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = (Connection) req.getAttribute("conn");
        CursoService cursoService = new CursoServiceImpl(conn);
        Long id;

        try{
            id = Long.valueOf(req.getParameter("id"));

        }catch (NumberFormatException nfe){
            id = 0L;
            nfe.getMessage();
        }

        if(id > 0){
            cursoService.eliminarCurso(id);
            resp.sendRedirect(req.getContextPath() + "/cursos");
        } else {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST,"El valor del id no puede ser null");
        }
    }
}
