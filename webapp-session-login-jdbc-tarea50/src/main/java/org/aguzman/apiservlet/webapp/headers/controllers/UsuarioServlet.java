package org.aguzman.apiservlet.webapp.headers.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.aguzman.apiservlet.webapp.headers.models.Usuario;
import org.aguzman.apiservlet.webapp.headers.services.LoginService;
import org.aguzman.apiservlet.webapp.headers.services.LoginServiceSessionImpl;
import org.aguzman.apiservlet.webapp.headers.services.UsuarioService;
import org.aguzman.apiservlet.webapp.headers.services.UsuarioServiceImpl;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import java.util.Optional;

@WebServlet("/usuarios")
public class UsuarioServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = (Connection) req.getAttribute("conn");
        UsuarioService service = new UsuarioServiceImpl(conn);
        List<Usuario> usuarios = service.listar();
        LoginService auth = new LoginServiceSessionImpl();
        Optional<String> username = auth.getUsername(req);

        req.setAttribute("usuarios", usuarios);
        req.setAttribute("username", username);

        getServletContext().getRequestDispatcher("/usuarios/listar.jsp").forward(req,resp);

    }
}
