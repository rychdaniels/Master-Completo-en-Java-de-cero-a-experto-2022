package org.rraya.apiservlet.webapp.bbdd.tarea10.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter("/*")
public class ConexionFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        /*try (Connection conn = ConexionBaseDatosDataSource.getConnection()) {

            if (conn.getAutoCommit()) {
                conn.setAutoCommit(false);
            }
*/
            try {
//              request.setAttribute("conn", conn);
                chain.doFilter(request, response);
//                conn.commit();
            } catch (Exception e) {
  //              conn.rollback();
                ((HttpServletResponse)response).sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
                e.printStackTrace();
            }
    /*    } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }*/
    }
}
