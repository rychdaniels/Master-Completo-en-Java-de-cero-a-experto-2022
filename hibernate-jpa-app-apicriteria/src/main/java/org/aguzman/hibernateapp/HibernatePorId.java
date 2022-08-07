package org.aguzman.hibernateapp;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.aguzman.hibernateapp.entity.Cliente;
import org.aguzman.hibernateapp.util.JpaUtil;

import java.util.Scanner;

public class HibernatePorId {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        System.out.println("Ingrese el id: ");
        Long id = s.nextLong();
        EntityManager em = JpaUtil.getEntityManager();
        Cliente cliente = em.find(Cliente.class, id);
        System.out.println(cliente);

        Cliente cliente2 = em.find(Cliente.class, id);
        System.out.println(cliente2);

        em.close();
    }
}
