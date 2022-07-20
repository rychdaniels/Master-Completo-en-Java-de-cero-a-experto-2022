package org.aguzman.apiservlet.webapp.headers.repositories;

import org.aguzman.apiservlet.webapp.headers.models.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRepositoryImpl implements UsuarioRepository{
    private Connection conn;

    public UsuarioRepositoryImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Usuario> listar() throws SQLException{
        List<Usuario> usuarios = new ArrayList<>();

        try(Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM usuarios")){
                while (rs.next()){
                    Usuario usuario = mapUsuario(rs);
                    usuarios.add(usuario);
                }
        }
        return usuarios;
    }

    @Override
    public Usuario porId(Long id) throws SQLException{
        Usuario usuario = null;

        try(PreparedStatement ps = conn.prepareStatement("SELECT * FROM usuarios WHERE id = ?");) {

            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()){
                if (rs.next()){
                    usuario = mapUsuario(rs);
                }
            }
        }

        return usuario;
    }

    @Override
    public void guardar(Usuario usuario) throws SQLException{
        String query;
        if(usuario.getId() != null && usuario.getId() > 0){
            query = "UPDATE usuarios SET username = ?, password = ?, email = ? WHERE id = ?";
        } else {
            query = "INSERT INTO usuarios (username, password, email) values (?, ?, ?)";
        }

        try (PreparedStatement ps = conn.prepareStatement(query);){
            ps.setString(1, usuario.getUsername());
            ps.setString(2, usuario.getPassword());
            ps.setString(3, usuario.getEmail());

            if(usuario.getId() != null && usuario.getId() > 0){
                ps.setLong(4, usuario.getId());
            }

            ps.executeUpdate();
        }
    }

    @Override
    public void eliminar(Long id) throws SQLException{
        String query = "DELETE FROM usuarios WHERE id = ?";
        try(PreparedStatement ps = conn.prepareStatement(query);){
            ps.setLong(1, id);
            ps.executeUpdate();
        }
    }

    @Override
    public Usuario porUsername(String username) throws SQLException {
        Usuario usuario = null;
        try (PreparedStatement stmt = conn.prepareStatement("select * from usuarios where username=?")) {
            stmt.setString(1, username);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    usuario = new Usuario();
                    usuario.setId(rs.getLong("id"));
                    usuario.setUsername(rs.getString("username"));
                    usuario.setPassword(rs.getString("password"));
                    usuario.setEmail(rs.getString("email"));
                }
            }
        }
        return usuario;
    }

    public Usuario mapUsuario(ResultSet rs) throws SQLException{
        Usuario usuario = new Usuario();

        usuario.setId(rs.getLong("id"));
        usuario.setUsername(rs.getString("username"));
        usuario.setEmail(rs.getString("email"));

        return usuario;
    }
}
