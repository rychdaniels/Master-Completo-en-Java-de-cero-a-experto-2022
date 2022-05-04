import org.rraya.jdbc.MantenimientoUsuarios;
import org.rraya.jdbc.modelo.Usuario;
import org.rraya.jdbc.repositorio.Repositorio;
import org.rraya.jdbc.util.ConexionBaseDatos;

import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws SQLException {

        try ( Connection conn = ConexionBaseDatos.getInstance()) {
            Repositorio<Usuario> repositorio = new MantenimientoUsuarios();
            int opcionIndice = 0;
            do {
                Map<String, Integer> operaciones = new HashMap();
                operaciones.put("Actualizar", 1);
                operaciones.put("Eliminar", 2);
                operaciones.put("Agregar", 3);
                operaciones.put("Listar", 4);
                operaciones.put("Salir", 5);

                Object[] opArreglo = operaciones.keySet().toArray();
                Object opcion = JOptionPane.showInputDialog(null,
                        "Seleccione un Operación", "Mantenedor de Usuario", JOptionPane.INFORMATION_MESSAGE, null, opArreglo, opArreglo[0]);

                if (opcion == null) {
                    JOptionPane.showMessageDialog(null, "Debe seleccionar una operación");
                } else {
                    opcionIndice = operaciones.get(opcion.toString());
                    Long id;
                    String username;
                    String password;
                    String email;

                    switch (opcionIndice) {
                        case 1 -> {
                            id = Long.valueOf(JOptionPane.showInputDialog(null, "Ingresar el id del usuario para Actualizar:"));

                            Usuario usuario = repositorio.porId(id);
                            if (usuario != null) {
                                username = JOptionPane.showInputDialog(null, "Ingresar el username:", usuario.getUsername());
                                password = JOptionPane.showInputDialog(null, "Ingresar el password:", usuario.getPassword());
                                email = JOptionPane.showInputDialog(null, "Ingresar el email:", usuario.getEmail());

                                usuario.setUsername(username);
                                usuario.setPassword(password);
                                usuario.setEmail(email);

                                repositorio.guardar(usuario);

                                JOptionPane.showMessageDialog(null, "Usuario actualizado correctamente");
                            } else {
                                JOptionPane.showMessageDialog(null, "No existe el id del usario en la base de datos");
                            }
                        }
                        case 2 -> {
                            id = Long.valueOf(JOptionPane.showInputDialog(null, "Ingresar el id del usuario para eliminar:"));
                            repositorio.eliminar(id);
                            JOptionPane.showMessageDialog(null, "Usuario eliminado correctamente");
                        }
                        case 3 -> {
                            username = JOptionPane.showInputDialog(null, "Ingresar el username para un nuevo usuario:");
                            password = JOptionPane.showInputDialog(null, "Ingresar el password:");
                            email = JOptionPane.showInputDialog(null, "Ingresar el email:");

                            Usuario usuario = new Usuario();
                            usuario.setUsername(username);
                            usuario.setPassword(password);
                            usuario.setEmail(email);

                            repositorio.guardar(usuario);
                            JOptionPane.showMessageDialog(null, "Usuario agregado correctamente");
                        }
                        case 4 -> {
                            repositorio.listar().forEach(System.out::println);
                        }
                    }

                }

            } while (opcionIndice != 5);

            JOptionPane.showMessageDialog(null, "Haz salido con exito!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }


    }
}
