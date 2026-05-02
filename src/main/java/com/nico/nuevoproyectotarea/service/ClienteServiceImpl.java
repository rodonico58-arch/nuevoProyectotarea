package com.nico.nuevoproyectotarea.service;

import com.nico.nuevoproyectotarea.dto.ClienteDTO;
import com.nico.nuevoproyectotarea.entity.Cliente;
import com.nico.nuevoproyectotarea.repository.ClienteRepository;
import com.nico.nuevoproyectotarea.mapper.ClienteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements IClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteMapper clienteMapper;

    @Override
    public ClienteDTO crearCliente(ClienteDTO clienteDTO) {
        validarClienteDTO(clienteDTO);
        Cliente cliente = clienteMapper.dtoToEntity(clienteDTO);
        Cliente clienteGuardado = clienteRepository.save(cliente);
        return clienteMapper.entityToDTO(clienteGuardado);
    }

    @Override
    public ClienteDTO obtenerClientePorId(Integer id) {
        return clienteRepository.findById(id)
                .map(clienteMapper::entityToDTO)
                .orElse(null);
    }

    @Override
    public ClienteDTO obtenerClientePorEmail(String email) {
        Cliente cliente = clienteRepository.findByEmail(email);
        return cliente != null ? clienteMapper.entityToDTO(cliente) : null;
    }

    @Override
    public ClienteDTO obtenerClientePorDni(String dni) {
        Cliente cliente = clienteRepository.findByDni(dni);
        return cliente != null ? clienteMapper.entityToDTO(cliente) : null;
    }

    private void validarClienteDTO(ClienteDTO clienteDTO) {
        if (clienteDTO.getNombre() == null || clienteDTO.getNombre().isEmpty()) {
            throw new IllegalArgumentException("El nombre del cliente es requerido");
        }
        if (clienteDTO.getEmail() == null || clienteDTO.getEmail().isEmpty()) {
            throw new IllegalArgumentException("El email del cliente es requerido");
        }
        if (clienteDTO.getDni() == null || clienteDTO.getDni().isEmpty()) {
            throw new IllegalArgumentException("El DNI del cliente es requerido");
        }
    }
}
