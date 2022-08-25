package org.rraya.apiservlet.webapp.bbdd.tarea10.repositorios;

import java.util.List;

public interface Repositorio<T>{

    List<T> listar() throws Exception;
    List<T> porNombre(String nombre) throws Exception;
    T porId(Long id) throws Exception;
    void eliminarCurso(Long id) throws Exception;
    void guardarCurso(T curso) throws Exception;
}
