package org.rraya.apiservlet.webapp.bbdd.tarea10.servicios;

import org.rraya.apiservlet.webapp.bbdd.tarea10.modelos.Curso;

import java.sql.SQLException;
import java.util.List;

public interface CursoService {
    List<Curso> listar();
    List<Curso> porNombre(String nombre) throws SQLException;
    void eliminarCurso(Long id);
}
