package com.nico.nuevoproyectotarea.controller;

import com.nico.nuevoproyectotarea.dto.ProductoDTO;
import com.nico.nuevoproyectotarea.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controlador REST para la gestión de Productos
 * Proporciona endpoints para CRUD operations
 */
@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ProductoController {

    private final IProductoService productoService;

    @Autowired
    public ProductoController(IProductoService productoService) {
        this.productoService = productoService;
    }

    /**
     * GET /api/productos - Obtiene todos los productos
     */
    @GetMapping
    public ResponseEntity<List<ProductoDTO>> obtenerTodos() {
        List<ProductoDTO> productos = productoService.obtenerTodos();
        return ResponseEntity.ok(productos);
    }

    /**
     * GET /api/productos/{id} - Obtiene un producto por ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<ProductoDTO> obtenerPorId(@PathVariable Integer id) {
        Optional<ProductoDTO> producto = productoService.obtenerPorId(id);
        return producto.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * GET /api/productos/nombre/{nombre} - Obtiene un producto por nombre
     */
    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<ProductoDTO> obtenerPorNombre(@PathVariable String nombre) {
        Optional<ProductoDTO> producto = productoService.obtenerPorNombre(nombre);
        return producto.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * GET /api/productos/activos/lista - Obtiene todos los productos activos
     */
    @GetMapping("/activos/lista")
    public ResponseEntity<List<ProductoDTO>> obtenerActivos() {
        List<ProductoDTO> productos = productoService.obtenerActivos();
        return ResponseEntity.ok(productos);
    }

    /**
     * GET /api/productos/proveedor/{email} - Obtiene productos por proveedor email
     */
    @GetMapping("/proveedor/{email}")
    public ResponseEntity<List<ProductoDTO>> obtenerPorProveedorEmail(@PathVariable String email) {
        List<ProductoDTO> productos = productoService.obtenerPorProveedorEmail(email);
        return ResponseEntity.ok(productos);
    }

    /**
     * GET /api/productos/stock-bajo/{cantidad} - Obtiene productos con stock bajo
     */
    @GetMapping("/stock-bajo/{cantidad}")
    public ResponseEntity<List<ProductoDTO>> obtenerProductosBajoStock(@PathVariable Integer cantidad) {
        List<ProductoDTO> productos = productoService.obtenerProductosBajoStock(cantidad);
        return ResponseEntity.ok(productos);
    }

    /**
     * POST /api/productos - Crea un nuevo producto
     */
    @PostMapping
    public ResponseEntity<ProductoDTO> crear(@RequestBody ProductoDTO productoDTO) {
        try {
            ProductoDTO productoCreado = productoService.crear(productoDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(productoCreado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    /**
     * PUT /api/productos/{id} - Actualiza un producto existente
     */
    @PutMapping("/{id}")
    public ResponseEntity<ProductoDTO> actualizar(@PathVariable Integer id, @RequestBody ProductoDTO productoDTO) {
        try {
            ProductoDTO productoActualizado = productoService.actualizar(id, productoDTO);
            return ResponseEntity.ok(productoActualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    /**
     * DELETE /api/productos/{id} - Marca un producto como inactivo (soft delete)
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        try {
            productoService.eliminar(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * DELETE /api/productos/{id}/permanente - Elimina un producto permanentemente de la BD
     */
    @DeleteMapping("/{id}/permanente")
    public ResponseEntity<Void> eliminarPermanente(@PathVariable Integer id) {
        try {
            productoService.eliminarPermanente(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * HEAD /api/productos/{id} - Verifica si un producto existe
     */
    @RequestMapping(value = "/{id}", method = org.springframework.web.bind.annotation.RequestMethod.HEAD)
    public ResponseEntity<Void> existe(@PathVariable Integer id) {
        if (productoService.existe(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
