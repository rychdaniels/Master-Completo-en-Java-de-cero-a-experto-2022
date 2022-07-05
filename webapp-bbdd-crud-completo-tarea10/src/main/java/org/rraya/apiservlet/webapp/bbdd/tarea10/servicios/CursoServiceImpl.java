package org.rraya.apiservlet.webapp.bbdd.tarea10.servicios;

import org.rraya.apiservlet.webapp.bbdd.tarea10.modelos.Curso;
import org.rraya.apiservlet.webapp.bbdd.tarea10.repositorios.CursoRepositorioImpl;
import org.rraya.apiservlet.webapp.bbdd.tarea10.repositorios.Repositorio;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CursoServiceImpl implements CursoService{
    Repositorio<Curso> repositorio;

    public CursoServiceImpl(Connection conn) {
        this.repositorio = new CursoRepositorioImpl(conn);
    }

    @Override
    public List<Curso> listar() {
        try {
            return this.repositorio.listar();
        } catch (SQLException sqle){
            System.out.println("Ocurrió un error al obtener los datos " + sqle.getMessage());
        }
        return null;
    }

    @Override
    public List<Curso> porNombre(String nombre){
        try {
            return this.repositorio.porNombre(nombre);
        } catch (SQLException sqle){
            System.out.println("Ocurrió un error al obtener los datos " + sqle.getMessage());
            throw new RuntimeException(sqle.getMessage());
        }
    }

    @Override
    public void eliminarCurso(Long id) {
        try{
            this.repositorio.eliminarCurso(id);
        } catch (SQLException sqle) {
            System.out.println("Ocurrió un error al eliminar los datos " + sqle.getMessage());
            throw new RuntimeException(sqle.getMessage());
        }
    }
}
