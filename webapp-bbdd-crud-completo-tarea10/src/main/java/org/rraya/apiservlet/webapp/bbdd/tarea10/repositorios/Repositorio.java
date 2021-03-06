package org.rraya.apiservlet.webapp.bbdd.tarea10.repositorios;

import java.sql.SQLException;
import java.util.List;

public interface Repositorio<T>{

    List<T> listar() throws SQLException;
    List<T> porNombre(String nombre) throws SQLException;
    T porId(Long id) throws SQLException;
    void eliminarCurso(Long id) throws SQLException;
    void guardarCurso(T curso) throws SQLException;
}
