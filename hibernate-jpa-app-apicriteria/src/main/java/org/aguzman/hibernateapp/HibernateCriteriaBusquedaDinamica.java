package org.aguzman.hibernateapp;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.aguzman.hibernateapp.entity.Cliente;
import org.aguzman.hibernateapp.util.JpaUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HibernateCriteriaBusquedaDinamica {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        System.out.println("Filtro para nombre: ");
        String nombre = s.nextLine();

        System.out.println("Filtro para el apellido: ");
        String apellido = s.nextLine();

        System.out.println("Filtro para la forma de pago: ");
        String formaPago = s.nextLine();

        EntityManager em = JpaUtil.getEntityManager();

        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<Cliente> query = cb.createQuery(Cliente.class);
        Root<Cliente> from = query.from(Cliente.class);

        List<Predicate> condiciones = new ArrayList<>();

        if (nombre != null && !nombre.isEmpty()) {
            condiciones.add(cb.equal(from.get("nombre"), nombre));
        }

        if (apellido != null && !apellido.isEmpty()) {
            condiciones.add(cb.equal(from.get("apellido"), apellido));
        }

        if (formaPago != null && !formaPago.equals("")) {
            condiciones.add(cb.equal(from.get("formaPago"), formaPago));
        }

        query.select(from).where(cb.and(condiciones.toArray(new Predicate[condiciones.size()])));

        List<Cliente> clientes = em.createQuery(query).getResultList();
        clientes.forEach(System.out::println);

        em.close();
    }
}
