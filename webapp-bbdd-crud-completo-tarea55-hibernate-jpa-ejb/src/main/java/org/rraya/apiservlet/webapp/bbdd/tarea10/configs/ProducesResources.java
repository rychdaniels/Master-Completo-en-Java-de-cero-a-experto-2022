package org.rraya.apiservlet.webapp.bbdd.tarea10.configs;

import jakarta.annotation.Resource;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Disposes;
import jakarta.enterprise.inject.Produces;
import jakarta.enterprise.inject.spi.InjectionPoint;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceUnit;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Logger;

@ApplicationScoped
public class ProducesResources {

    @Inject
    private Logger log;

    @Resource(lookup = "java:/MySqlDS")
    private DataSource ds;

    @PersistenceUnit(name = "crud")
    private EntityManagerFactory emf;

    @Produces
    @RequestScoped
    @MySqlConn
    private Connection beanConnection() throws SQLException {
        log.info("Conectando a la BD");
        return ds.getConnection();
    }

    public void close(@Disposes @MySqlConn Connection connection) throws SQLException {
        connection.close();
        log.info("cerrando la conexion a la bbdd mysql!");
    }

    @Produces
    private Logger beanLogger(InjectionPoint injectionPoint){
        return Logger.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
    }

    @Produces
    @RequestScoped
    private EntityManager beanEntityManager() {
        return emf.createEntityManager();
    }

    public void close(@Disposes EntityManager entityManager) {
        if (entityManager.isOpen()) {
            entityManager.close();
            log.info("cerrando la conexion del EntityManager!");
        }
    }
}
