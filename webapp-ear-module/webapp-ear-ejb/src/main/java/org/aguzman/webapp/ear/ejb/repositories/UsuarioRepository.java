package org.aguzman.webapp.ear.ejb.repositories;

import org.aguzman.webapp.ear.ejb.entities.Usuario;

import java.util.List;

public interface UsuarioRepository {
    List<Usuario> listar();
}
