package org.rraya.apiservlet.webapp.bbdd.tarea9.repositorios;

import java.sql.SQLException;
import java.util.List;

public interface Repositorio<T> {

    List<T> listar() throws SQLException;
    List<T> porNombre(String nombre) throws SQLException;
}
