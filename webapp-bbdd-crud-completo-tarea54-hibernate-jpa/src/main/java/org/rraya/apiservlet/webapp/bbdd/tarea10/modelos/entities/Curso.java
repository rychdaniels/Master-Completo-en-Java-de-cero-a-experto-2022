package org.rraya.apiservlet.webapp.bbdd.tarea10.modelos.entities;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cursos")
public class Curso implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Es esquivalente a decir que sera autoincremental
    @Column(name = "id")
    private Long idCurso;

    @Column(name = "nombre")
    private String nombreCurso;

    @Column(name = "descripcion")
    private String descripcionCurso;

    @Column(name = "instructor")
    private String nombreInstructor;

    @Column(name = "duracion")
    private Double duracion;

    public Long getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Long idCurso) {
        this.idCurso = idCurso;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public String getDescripcionCurso() {
        return descripcionCurso;
    }

    public void setDescripcionCurso(String descripcionCurso) {
        this.descripcionCurso = descripcionCurso;
    }

    public String getNombreInstructor() {
        return nombreInstructor;
    }

    public void setNombreInstructor(String nombreInstructor) {
        this.nombreInstructor = nombreInstructor;
    }

    public Double getDuracion() {
        return duracion;
    }

    public void setDuracion(Double duracion) {
        this.duracion = duracion;
    }
}
