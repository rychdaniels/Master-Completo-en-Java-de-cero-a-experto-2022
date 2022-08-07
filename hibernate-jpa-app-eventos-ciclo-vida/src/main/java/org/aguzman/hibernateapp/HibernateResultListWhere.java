package org.aguzman.hibernateapp;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.aguzman.hibernateapp.entity.Cliente;
import org.aguzman.hibernateapp.util.JpaUtil;

import java.util.List;
import java.util.Scanner;

public class HibernateResultListWhere {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        EntityManager em = JpaUtil.getEntityManager();
        Query query = em.createQuery("select c from Cliente c where c.formaPago=?1", Cliente.class);
        System.out.println("Ingrese una forma de pago: ");
        String pago = s.next();
        query.setParameter(1, pago);
//        query.setMaxResults(1);
        List<Cliente> clientes = query.getResultList();
        System.out.println(clientes);
        em.close();
    }
}
