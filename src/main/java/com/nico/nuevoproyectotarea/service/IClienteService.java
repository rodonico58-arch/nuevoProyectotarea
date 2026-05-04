package com.nico.nuevoproyectotarea.service;

import com.nico.nuevoproyectotarea.dto.ClienteDTO;

public interface IClienteService {
    ClienteDTO crearCliente(ClienteDTO clienteDTO);
    ClienteDTO obtenerClientePorId(Integer id);
    ClienteDTO obtenerClientePorEmail(String email);
    ClienteDTO obtenerClientePorDni(String dni);
    boolean eliminarCliente(Integer id);
}
