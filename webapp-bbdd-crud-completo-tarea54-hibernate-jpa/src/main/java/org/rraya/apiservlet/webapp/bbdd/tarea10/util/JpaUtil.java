package org.rraya.apiservlet.webapp.bbdd.tarea10.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaUtil {
    private static final EntityManagerFactory entityManagerFactory = buildEntityManagerFactory();


    private static EntityManagerFactory buildEntityManagerFactory() {
        return Persistence.createEntityManagerFactory("crud");
    }

    public static EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }
}
