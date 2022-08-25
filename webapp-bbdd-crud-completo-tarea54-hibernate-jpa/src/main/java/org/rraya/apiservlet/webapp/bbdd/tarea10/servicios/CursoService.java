package org.rraya.apiservlet.webapp.bbdd.tarea10.servicios;

import org.rraya.apiservlet.webapp.bbdd.tarea10.modelos.entities.Curso;

import java.util.List;
import java.util.Optional;

public interface CursoService {
    List<Curso> listar();
    List<Curso> porNombre(String nombre);
    Optional<Curso> porId(Long id);
    void eliminarCurso(Long id);
    void guardarCurso(Curso curso);
}
