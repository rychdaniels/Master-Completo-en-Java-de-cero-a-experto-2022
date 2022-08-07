package org.aguzman.hibernateapp.services;

import org.aguzman.hibernateapp.entity.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {
    List<Cliente> listar();
    Optional<Cliente> porId(Long id);
    void guardar(Cliente cliente);
    void eliminar(Long id);
}
