package org.aguzman.poointerfaces.repositorio;

import org.aguzman.poointerfaces.modelo.Cliente;

import java.util.List;

public interface OrdenableRepositorio {
    List<Cliente> listar(String campo, Direccion dir);
}
