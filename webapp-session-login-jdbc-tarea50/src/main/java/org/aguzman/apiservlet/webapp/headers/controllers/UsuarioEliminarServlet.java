package org.aguzman.apiservlet.webapp.headers.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.aguzman.apiservlet.webapp.headers.models.Usuario;
import org.aguzman.apiservlet.webapp.headers.services.UsuarioService;
import org.aguzman.apiservlet.webapp.headers.services.UsuarioServiceImpl;

import java.io.IOException;
import java.sql.Connection;
import java.util.Optional;

@WebServlet("/usuarios/eliminar")
public class UsuarioEliminarServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = (Connection)req.getAttribute("conn");
        UsuarioService service = new UsuarioServiceImpl(conn);

        Long id;
        try {
            id = Long.parseLong(req.getParameter("id"));
        } catch (NumberFormatException nbe){
            id = 0L;
        }

        if (id > 0){
            Optional<Usuario> respuesta = service.porId(id);

            if (respuesta.isPresent()){
                service.eliminar(id);
                resp.sendRedirect(req.getContextPath() + "/usuarios");
            } else {
                resp.sendError(HttpServletResponse.SC_NOT_FOUND, "No existe este usuario en la BD");
            }
        } else {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "El id no puede sr null");
        }
    }
}
