package com.nico.nuevoproyectotarea.mapper;

import com.nico.nuevoproyectotarea.dto.ClienteDTO;
import com.nico.nuevoproyectotarea.entity.Cliente;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {

    public ClienteDTO entityToDTO(Cliente cliente) {
        ClienteDTO dto = new ClienteDTO();
        dto.setIdcliente(cliente.getIdcliente());
        dto.setNombre(cliente.getNombre());
        dto.setDni(cliente.getDni());
        dto.setEmail(cliente.getEmail());
        dto.setTelefono(cliente.getTelefono());
        dto.setFechaAlta(cliente.getFechaAlta());
        dto.setCiudad(cliente.getCiudad());
        dto.setCodigoPostal(cliente.getCodigoPostal());
        dto.setDireccion(cliente.getDireccion());
        dto.setPais(cliente.getPais());
        return dto;
    }

    public Cliente dtoToEntity(ClienteDTO dto) {
        Cliente cliente = new Cliente();
        cliente.setNombre(dto.getNombre());
        cliente.setDni(dto.getDni());
        cliente.setEmail(dto.getEmail());
        cliente.setTelefono(dto.getTelefono());
        cliente.setCiudad(dto.getCiudad());
        cliente.setCodigoPostal(dto.getCodigoPostal());
        cliente.setDireccion(dto.getDireccion());
        cliente.setPais(dto.getPais());
        return cliente;
    }
}
