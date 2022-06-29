package org.rraya.apiservlet.webapp.bbdd.tarea9.repositorios;

import org.rraya.apiservlet.webapp.bbdd.tarea9.modelos.Curso;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CursoRepositorioImpl implements Repositorio<Curso>{
    private Connection conn;

    public CursoRepositorioImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List listar() throws SQLException{

        List<Curso> cursos = new ArrayList<>();


        try(Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM cursos"); ) {

            while (rs.next()){
                Curso curso = mapCurso(rs);
                cursos.add(curso);
            }

        }

        return cursos;
    }

    @Override
    public List porNombre(String nombre) throws SQLException{
        List<Curso> cursosPorNombre = new ArrayList<>();

        try(PreparedStatement stm = conn.prepareStatement("SELECT * FROM cursos c WHERE c.NOMBRE LIKE ?");) {
            stm.setString(1, "%" + nombre + "%");

            try (ResultSet rs = stm.executeQuery()){
                while (rs.next()) {
                    Curso curso = mapCurso(rs);
                    cursosPorNombre.add(curso);
                }
            }
        }

        return cursosPorNombre;
    }

    private Curso mapCurso(ResultSet rs) throws SQLException {
        Curso cursoMapeado = new Curso();
        cursoMapeado.setIdCurso(rs.getLong("id"));
        cursoMapeado.setNombreCurso(rs.getString("nombre"));
        cursoMapeado.setNombreInstructor(rs.getString("instructor"));
        cursoMapeado.setDescripcionCurso(rs.getString("descripcion"));
        cursoMapeado.setDuracion(rs.getDouble("duracion"));

        return cursoMapeado;
    }
}
