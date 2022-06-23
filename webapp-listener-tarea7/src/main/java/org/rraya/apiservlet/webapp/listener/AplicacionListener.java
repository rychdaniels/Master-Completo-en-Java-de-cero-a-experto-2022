package org.rraya.apiservlet.webapp.listener;

import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class AplicacionListener implements ServletRequestListener{

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        sre.getServletRequest().setAttribute("nombreCompleto", "Ricardo Raya");
    }
}
