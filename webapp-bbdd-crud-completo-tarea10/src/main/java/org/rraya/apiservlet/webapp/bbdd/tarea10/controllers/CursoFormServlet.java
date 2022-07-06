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
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;

@WebServlet("/cursos/form")
public class CursoFormServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger((CursoFormServlet.class).getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info(CursoFormServlet.class.getName() + ":::::: doGet()");
        Connection conn = (Connection) req.getAttribute("conn");
        CursoService service = new CursoServiceImpl(conn);
        long id;
        try {
            id = Long.parseLong(req.getParameter("id"));
        } catch (NumberFormatException e){
            id = 0L;
        }

        Curso curso = new Curso();

        if (id > 0) {
            Optional<Curso> o = service.porId(id);
            if (o.isPresent()) {
                curso = o.get();
            }
        }

        req.setAttribute("curso", curso);
        getServletContext().getRequestDispatcher("/form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info(CursoFormServlet.class.getName() + ":::::: doPost()");
        Connection conn = (Connection) req.getAttribute("conn");
        CursoService service = new CursoServiceImpl(conn);

        Map<String, String> errores = new HashMap<>();

        String nombre = req.getParameter("nombre");
        if (nombre == null || nombre.isBlank()) {
            errores.put("nombre", "El nombre es obligatorio");
            logger.info("El nombre es obligatorio");
        }

        String instructor = req.getParameter("instructor");
        if (instructor == null ||  instructor.isBlank()){
            errores.put("instructor", "El nombre del instructor es obligatorio");
            logger.info("El nombre del instructor es obligatorio");
        }

        double duracion;
        try{
            duracion = Double.valueOf(req.getParameter("duracion"));
        } catch (NumberFormatException nfe) {
            duracion = 0;
            logger.info("Error al convertir la duracion del curso " + nfe.getStackTrace());
        }

        String descripcion = req.getParameter("descripcion");
        if (descripcion == null ||  descripcion.isBlank()){
            errores.put("descripcion", "La descripcion es obligatoria");
            logger.info("La descripcion es obligatoria");
        }
        logger.info("La duración debe ser mayor a 0 -> " + duracion);
        if(duracion == 0){
            errores.put("duracionTiempo", "La duración debe ser mayor a 0");
            logger.info("La duración debe ser mayor a 0");
        }

        Curso curso = new Curso();

        curso.setNombreCurso(nombre);
        curso.setDescripcionCurso(descripcion);
        curso.setNombreInstructor(instructor);
        curso.setDuracion(duracion);

        if(errores.isEmpty()){
            service.guardarCurso(curso);
            resp.sendRedirect(req.getContextPath() + "/cursos");
        } else {
            req.setAttribute("errores", errores);
            req.setAttribute("curso", curso);
            getServletContext().getRequestDispatcher("/form.jsp").forward(req, resp);
        }


    }
}
