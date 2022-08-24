package org.aguzman.hibernateapp;

import jakarta.persistence.EntityManager;
import org.aguzman.hibernateapp.entity.Cliente;
import org.aguzman.hibernateapp.entity.ClienteDetalle;
import org.aguzman.hibernateapp.util.JpaUtil;

public class HibernateAsociacionesOneToOneBidireccionalFind {
    public static void main(String[] args) {

        EntityManager em = JpaUtil.getEntityManager();

        try {
            em.getTransaction().begin();

            Cliente cliente = em.find(Cliente.class, 2L);

            ClienteDetalle detalle = new ClienteDetalle(true, 8000L);
            cliente.addDetalle(detalle);

            em.getTransaction().commit();

            System.out.println(cliente);
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }finally {
            em.close();
        }
    }
}
