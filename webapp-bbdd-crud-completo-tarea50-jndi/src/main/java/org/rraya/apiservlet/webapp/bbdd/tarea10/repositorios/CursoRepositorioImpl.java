package org.rraya.apiservlet.webapp.bbdd.tarea10.repositorios;

import org.rraya.apiservlet.webapp.bbdd.tarea10.controllers.CursoFormServlet;
import org.rraya.apiservlet.webapp.bbdd.tarea10.modelos.Curso;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class CursoRepositorioImpl implements Repositorio<Curso>{
    private static final Logger logger = Logger.getLogger((CursoRepositorioImpl.class).getName());

    private Connection conn;

    public CursoRepositorioImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List listar() throws SQLException{
        logger.info("Listando cursos.");

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
        logger.info("Obteniendo curso por nombre");
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

    @Override
    public void eliminarCurso(Long id) throws SQLException {
        logger.info("Eliminando curso");
        try(PreparedStatement stmt = conn.prepareStatement("DELETE FROM cursos where id = ?");){
            stmt.setLong(1, id);
            stmt.executeUpdate();
        }
    }

    @Override
    public void guardarCurso(Curso curso) throws SQLException{
        logger.info("Guardando curso:::::: id del curso que se guardara " + curso.getIdCurso());

        String query;

        if(curso.getIdCurso() != null && curso.getIdCurso() > 0){
            query = "UPDATE cursos set nombre = ?, descripcion = ?, instructor = ?, duracion = ? WHERE id = ?";
        } else {
            query = "INSERT INTO cursos (nombre, descripcion, instructor, duracion) VALUES (?,?,?,?)";
        }
        try(PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setString(1, curso.getNombreCurso());
            stmt.setString(2, curso.getDescripcionCurso());
            stmt.setString(3, curso.getNombreInstructor());
            stmt.setDouble(4, curso.getDuracion());

            if(curso.getIdCurso() != null && curso.getIdCurso() > 0){
                stmt.setDouble(5, curso.getIdCurso());
            }

            stmt.executeUpdate();
        }
    }


    @Override
    public Curso porId(Long id) throws SQLException {
        logger.info("Obteniendo curso por id");

        Curso curso = null;
        String query = "SELECT * FROM cursos WHERE id = ?";
        try(PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setLong(1, id);

            try(ResultSet rs = stmt.executeQuery()){
                if (rs.next()){
                    curso = mapCurso(rs);
                }
            }
        }

        return curso;
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
