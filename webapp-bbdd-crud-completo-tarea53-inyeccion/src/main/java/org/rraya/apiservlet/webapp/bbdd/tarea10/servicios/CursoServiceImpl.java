package org.rraya.apiservlet.webapp.bbdd.tarea10.servicios;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.rraya.apiservlet.webapp.bbdd.tarea10.interceptors.TransactionalJdbc;
import org.rraya.apiservlet.webapp.bbdd.tarea10.modelos.Curso;
import org.rraya.apiservlet.webapp.bbdd.tarea10.repositorios.Repositorio;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@ApplicationScoped
public class CursoServiceImpl implements CursoService{

    //private static final Logger logger = Logger.getLogger((CursoServiceImpl.class).getName());
    @Inject
    private Logger logger;

    @Inject
    private Repositorio<Curso> repositorio;

    @Override
    public List<Curso> listar() {
        try {
            return repositorio.listar();
        } catch (SQLException sqle){
            logger.info("Ocurrió un error al obtener los datos " + sqle.getMessage());
        }
        return null;
    }

    @Override
    public List<Curso> porNombre(String nombre){
        try {
            return repositorio.porNombre(nombre);
        } catch (SQLException sqle){
            logger.info("Ocurrió un error al obtener los datos " + sqle.getMessage());
            throw new RuntimeException(sqle.getMessage());
        }
    }

    @Override
    @TransactionalJdbc
    public void eliminarCurso(Long id) {
        try{
            repositorio.eliminarCurso(id);
        } catch (SQLException sqle) {
            logger.info("Ocurrió un error al eliminar los datos " + sqle.getMessage());
            throw new RuntimeException(sqle.getMessage());
        }
    }

    @Override
    @TransactionalJdbc
    public void guardarCurso(Curso curso) {
        try{
            repositorio.guardarCurso(curso);
        } catch (Exception sqle) {
            logger.info("Ocurrió un error al guardar los datos " + sqle.getMessage());
            throw new RuntimeException(sqle.getMessage());
        }
    }

    @Override
    public Optional<Curso> porId(Long id){
        try{
            return Optional.ofNullable(repositorio.porId(id));
        } catch (SQLException sqle) {
            logger.info("Ocurrió un error al obtener el curso por id " + sqle.getMessage());
            throw new RuntimeException(sqle.getMessage());
        }
    }
}
