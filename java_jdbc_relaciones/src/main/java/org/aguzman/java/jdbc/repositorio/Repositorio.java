package org.aguzman.java.jdbc.repositorio;

import java.util.List;

public interface Repositorio<T> {
    List<T> listar();

    T porId(Long id);

    void guardar(T t);

    void eliminar(Long id);
}
