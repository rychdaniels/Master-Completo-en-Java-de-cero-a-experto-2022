package org.aguzman.apiservlet.webapp.headers.controllers;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.aguzman.apiservlet.webapp.headers.models.Carro;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

@WebServlet("/actualizar-carro")
public class ActualizarCarroServlet extends HttpServlet {

    Carro carro = new Carro();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute("carro") != null) {
            Carro carro = (Carro) session.getAttribute("carro");
            eliminaProductos(req, carro);
            updateCantidades(req, carro);
        }

        resp.sendRedirect(req.getContextPath() + "/ver-carro");
    }

    private void eliminaProductos(HttpServletRequest req, Carro carro){

        String idsProductos[] = req.getParameterValues("deleteProductos");

        if(idsProductos != null && idsProductos.length > 0) {
            List<String> productosIds = Arrays.asList(idsProductos);
            carro.deleteItemsCarro(productosIds);
        }

    }

    private void updateCantidades(HttpServletRequest request, Carro carro) {

        Enumeration<String> enumer = request.getParameterNames();

        // Iteramos a traves de los parámetros y buscamos los que empiezan con
        // "cant_". El campo cant en la vista fueron nombrados "cant_" + productoId.
        // Obtenemos el id de cada producto y su correspondiente cantidad ;-).
        while (enumer.hasMoreElements()) {
            String paramName = enumer.nextElement();
            if (paramName.startsWith("cant_")) {
                String id = paramName.substring(5);
                String cantidad = request.getParameter(paramName);
                if (cantidad != null) {
                    carro.updateCantidad(id, Integer.parseInt(cantidad));
                }
            }
        }
    }
}
