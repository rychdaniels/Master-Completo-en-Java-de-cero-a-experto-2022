package org.aguzman.hibernateapp;

import jakarta.persistence.EntityManager;
import org.aguzman.hibernateapp.entity.Cliente;
import org.aguzman.hibernateapp.util.JpaUtil;

import javax.swing.*;

public class HibernateCrear {
    public static void main(String[] args) {

        EntityManager em = JpaUtil.getEntityManager();
        try {

            String nombre = JOptionPane.showInputDialog("Ingrese el nombre:");
            String apellido = JOptionPane.showInputDialog("Ingrese el apellido:");
            String pago = JOptionPane.showInputDialog("Ingrese la forma de pago:");

            em.getTransaction().begin();

            Cliente c = new Cliente();
            c.setNombre(nombre);
            c.setApellido(apellido);
            c.setFormaPago(pago);
            em.persist(c);
            em.getTransaction().commit();

            System.out.println("el id del cliente registrado es " + c.getId());
            c = em.find(Cliente.class, c.getId());
            System.out.println(c);
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
