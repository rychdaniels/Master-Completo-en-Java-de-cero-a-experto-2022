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
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@WebServlet("/usuarios/form")
public class UsuarioFormServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = (Connection) req.getAttribute("conn");
        UsuarioService service = new UsuarioServiceImpl(conn);
        long id;
        try {
            id = Long.parseLong(req.getParameter("id"));
        } catch (NumberFormatException e) {
            id = 0L;
        }
        Usuario usuario = new Usuario();

        if (id > 0) {
            Optional<Usuario> o = service.porId(id);
            if (o.isPresent()) {
                usuario = o.get();
            }
        }

        req.setAttribute("usuario", usuario);
        req.setAttribute("title", req.getAttribute("title") + ": Registro de usuario");

        getServletContext().getRequestDispatcher("/usuarios/form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = (Connection)req.getAttribute("conn");
        UsuarioService service = new UsuarioServiceImpl(conn);

        Long id;
        try {
            id = Long.parseLong(req.getParameter("id"));
        } catch (NumberFormatException nbe){
            id = 0L;
        }

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        Map<String, String> errores = new HashMap<>();

        if (username == null || username.isBlank()) {
            errores.put("username", "el username es requerido!");
        }

        if ((id == 0) && (password == null || password.isBlank())) {
            errores.put("password", "el password es requerido!");
        }

        if (email == null || email.isBlank()) {
            errores.put("email", "el email es requerido!");
        }


        Usuario usuario = new Usuario();

        if (id > 0) {
            Optional<Usuario> o = service.porId(id);
            if (o.isPresent()) {
                usuario = o.get();
            }
        }

        usuario.setEmail(email);
        usuario.setUsername(username);

        if (password != null && !password.isBlank()) {
            usuario.setPassword(password);
        }

        if (errores.isEmpty()) {
            service.guardar(usuario);
            resp.sendRedirect(req.getContextPath() + "/usuarios");
        } else {
            req.setAttribute("errores", errores);
            req.setAttribute("usuario", usuario);
            req.setAttribute("title", req.getAttribute("title") + ": Formulario de usuario");
            getServletContext().getRequestDispatcher("/usuarios/form.jsp").forward(req, resp);
        }
    }
}
