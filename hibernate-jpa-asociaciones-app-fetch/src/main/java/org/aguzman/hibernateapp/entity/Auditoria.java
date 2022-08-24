package org.aguzman.hibernateapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.time.LocalDateTime;

@Embeddable
public class Auditoria {

    @Column(name = "creado_en")
    private LocalDateTime creadoEn;

    @Column(name = "editado_en")
    private LocalDateTime editadoEn;

    @PrePersist
    public void prePersist() {
        System.out.println("inicializar algo justo antes del persist");
        this.creadoEn = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        System.out.println("inicializar algo justo antes del update");
        this.editadoEn = LocalDateTime.now();
    }

    public LocalDateTime getCreadoEn() {
        return creadoEn;
    }

    public void setCreadoEn(LocalDateTime creadoEn) {
        this.creadoEn = creadoEn;
    }

    public LocalDateTime getEditadoEn() {
        return editadoEn;
    }

    public void setEditadoEn(LocalDateTime editadoEn) {
        this.editadoEn = editadoEn;
    }

}
