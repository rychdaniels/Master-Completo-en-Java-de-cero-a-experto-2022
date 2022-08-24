package org.aguzman.hibernateapp;

import jakarta.persistence.EntityManager;
import org.aguzman.hibernateapp.entity.Cliente;
import org.aguzman.hibernateapp.entity.Factura;
import org.aguzman.hibernateapp.util.JpaUtil;

public class HibernateAsociacionesOneToManyBidireccionalFind {
    public static void main(String[] args) {

        EntityManager em = JpaUtil.getEntityManager();
        try {

            em.getTransaction().begin();

            Cliente cliente = em.find(Cliente.class, 1L);

            Factura f1 = new Factura("compras de supermercado", 5000L);
            Factura f2 = new Factura("compras de tecnologia", 7000L);
            cliente.addFactura(f1)
                    .addFactura(f2);
//            em.merge(cliente);
            em.getTransaction().commit();
            System.out.println(cliente);

            em.getTransaction().begin();
            // Factura f3 = em.find(Factura.class, 1L);
            Factura f3 = new Factura("compras de supermercado", 5000L);
            f3.setId(1L);
            cliente.removeFactura(f3);
            em.getTransaction().commit();
            System.out.println(cliente);
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
