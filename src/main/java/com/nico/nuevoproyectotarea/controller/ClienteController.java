package com.nico.nuevoproyectotarea.controller;

import com.nico.nuevoproyectotarea.dto.ClienteDTO;
import com.nico.nuevoproyectotarea.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clientes")
@CrossOrigin(origins = "*")
public class ClienteController {

    @Autowired
    private IClienteService clienteService;

    /**
     * Endpoint para dar de alta un nuevo cliente
     * POST /api/clientes
     */
    @PostMapping
    public ResponseEntity<?> altaCliente(@RequestBody ClienteDTO clienteDTO) {
        try {
            ClienteDTO nuevoCliente = clienteService.crearCliente(clienteDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoCliente);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error de validación: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al crear el cliente: " + e.getMessage());
        }
    }

    /**
     * Endpoint para obtener cliente por ID
     * GET /api/clientes/{id}
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerCliente(@PathVariable Integer id) {
        try {
            ClienteDTO cliente = clienteService.obtenerClientePorId(id);
            if (cliente != null) {
                return ResponseEntity.ok(cliente);
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Cliente no encontrado");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al obtener cliente: " + e.getMessage());
        }
    }

    /**
     * Endpoint para obtener cliente por email
     * GET /api/clientes/email/{email}
     */
    @GetMapping("/email/{email}")
    public ResponseEntity<?> obtenerClientePorEmail(@PathVariable String email) {
        try {
            ClienteDTO cliente = clienteService.obtenerClientePorEmail(email);
            if (cliente != null) {
                return ResponseEntity.ok(cliente);
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Cliente no encontrado");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al obtener cliente: " + e.getMessage());
        }
    }

    /**
     * Endpoint para obtener cliente por DNI
     * GET /api/clientes/dni/{dni}
     */
    @GetMapping("/dni/{dni}")
    public ResponseEntity<?> obtenerClientePorDni(@PathVariable String dni) {
        try {
            ClienteDTO cliente = clienteService.obtenerClientePorDni(dni);
            if (cliente != null) {
                return ResponseEntity.ok(cliente);
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Cliente no encontrado");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al obtener cliente: " + e.getMessage());
        }
    }
}
