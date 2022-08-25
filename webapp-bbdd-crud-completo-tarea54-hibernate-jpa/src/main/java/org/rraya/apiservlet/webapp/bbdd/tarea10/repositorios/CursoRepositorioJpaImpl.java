package org.rraya.apiservlet.webapp.bbdd.tarea10.repositorios;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import org.rraya.apiservlet.webapp.bbdd.tarea10.configs.Repository;
import org.rraya.apiservlet.webapp.bbdd.tarea10.modelos.entities.Curso;

import java.sql.ResultSet;
import java.util.List;
import java.util.logging.Logger;

@RepositoryJpa
@Repository
public class CursoRepositorioJpaImpl implements Repositorio<Curso>{

    @Inject
    private Logger logger;
    //private static final Logger logger = Logger.getLogger((CursoRepositorioImpl.class).getName());

    @Inject
    private EntityManager em;


    @Override
    public List<Curso> listar() throws Exception{
        logger.info("Listando cursos con entity manager.");
        return em.createQuery("select c from Curso c", Curso.class).getResultList();
    }

    @Override
    public List<Curso> porNombre(String nombre) throws Exception{
        logger.info("Obteniendo curso por nombre con entity manager");


        return em.createQuery("select c from Curso c where c.nombreCurso like :nombre", Curso.class)
                .setParameter("nombre", "%" + nombre + "%")
                .getResultList();
    }

    @Override
    public void eliminarCurso(Long id) throws Exception {
        logger.info("Eliminando curso con entity manager");
        em.remove(porId(id));
    }

    @Override
    public void guardarCurso(Curso curso) throws Exception{

        if(curso.getIdCurso() != null && curso.getIdCurso() > 0) {
            em.merge(curso);
        } else {
            em.persist(curso);
        }
    }


    @Override
    public Curso porId(Long id) throws Exception {
        logger.info("Obteniendo curso por id con entity manager");
        return em.find(Curso.class, id);
    }

    private Curso mapCurso(ResultSet rs) throws Exception {
        Curso cursoMapeado = new Curso();
        cursoMapeado.setIdCurso(rs.getLong("id"));
        cursoMapeado.setNombreCurso(rs.getString("nombre"));
        cursoMapeado.setNombreInstructor(rs.getString("instructor"));
        cursoMapeado.setDescripcionCurso(rs.getString("descripcion"));
        cursoMapeado.setDuracion(rs.getDouble("duracion"));

        return cursoMapeado;
    }
}
