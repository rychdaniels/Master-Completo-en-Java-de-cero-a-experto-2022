package org.aguzman.java.jdbc;

import org.aguzman.java.jdbc.modelo.Categoria;
import org.aguzman.java.jdbc.modelo.Producto;
import org.aguzman.java.jdbc.repositorio.ProductoRepositorioImpl;
import org.aguzman.java.jdbc.repositorio.Repositorio;
import org.aguzman.java.jdbc.util.ConexionBaseDatos;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public class EjemploJdbcUpdate {
    public static void main(String[] args) {
        try (Connection conn = ConexionBaseDatos.getInstance()) {

            Repositorio<Producto> repositorio = new ProductoRepositorioImpl();
            System.out.println("============= listar =============");
            repositorio.listar().forEach(System.out::println);

            System.out.println("============= obtener por id =============");
            System.out.println(repositorio.porId(1L));

            System.out.println("============= editar producto =============");
            Producto producto = new Producto();
            producto.setId(5L);
            producto.setNombre("Teclado Cosair k95 mecánico");
            producto.setPrecio(700);
            Categoria categoria = new Categoria();
            categoria.setId(2L);
            producto.setCategoria(categoria);
            repositorio.guardar(producto);
            System.out.println("Producto editado con éxito");
            repositorio.listar().forEach(System.out::println);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
