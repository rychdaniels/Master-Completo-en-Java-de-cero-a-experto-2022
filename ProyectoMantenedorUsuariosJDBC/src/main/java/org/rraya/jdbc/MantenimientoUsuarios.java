package org.rraya.jdbc;

import org.rraya.jdbc.modelo.Usuario;
import org.rraya.jdbc.repositorio.Repositorio;
import org.rraya.jdbc.util.ConexionBaseDatos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MantenimientoUsuarios implements Repositorio<Usuario> {

    private Connection getConexion() throws SQLException {
        return ConexionBaseDatos.getInstance();
    }

    @Override
    public List<Usuario> listar() {
        List<Usuario> usuarios = new ArrayList<>();

        try (Statement stmt = getConexion().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM usuarios")){
            while (rs.next()){
                Usuario usuario = mapearUsuario(rs);
                usuarios.add(usuario);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuarios;
    }

    @Override
    public Usuario porId(Long id) {
        Usuario usuario = null;
        try(PreparedStatement ps = getConexion().prepareStatement("SELECT * FROM usuarios WHERE id = ?")) {
            ps.setLong(1, id);
            try(ResultSet rs = ps.executeQuery()){
               if( rs.next() ){
                   usuario = mapearUsuario(rs);
               }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return usuario;
    }

    @Override
    public void guardar(Usuario usuario) {
        String query;
        if(usuario.getId() == null) {
            query = "INSERT INTO usuarios(username, password, email) VALUES(?,?,?)";
        } else {
            query ="UPDATE usuarios SET username = ?, password = ?, email = ? WHERE id = ?";
        }

        try (PreparedStatement ps = getConexion().prepareStatement(query)){
            ps.setString(1, usuario.getUsername());
            ps.setString(2, usuario.getPassword());
            ps.setString(3, usuario.getEmail());

            if(usuario.getId() != null && usuario.getId() > 0){
                ps.setLong(4, usuario.getId());
            }

            ps.executeUpdate();

        } catch (SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public void eliminar(Long id) {
        try(PreparedStatement ps = getConexion().
                prepareStatement("DELETE FROM usuarios WHERE id = ?");) {
            ps.setLong(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Usuario mapearUsuario(ResultSet rs) throws SQLException {
        Usuario usuario = new Usuario();
        usuario.setId(rs.getLong("id"));
        usuario.setUsername(rs.getString("username"));
        usuario.setEmail(rs.getString("email"));
        usuario.setPassword(rs.getString("password"));
        return usuario;
    }
}
