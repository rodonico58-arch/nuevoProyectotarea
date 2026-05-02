package com.nico.nuevoproyectotarea.service;

import com.nico.nuevoproyectotarea.dto.ProductoDTO;
import java.util.List;
import java.util.Optional;

/**
 * Interfaz que define los contratos del servicio de Productos
 * Sigue el principio SOLID de Interface Segregation
 */
public interface IProductoService {

    /**
     * Obtiene todos los productos
     */
    List<ProductoDTO> obtenerTodos();

    /**
     * Obtiene un producto por su ID
     */
    Optional<ProductoDTO> obtenerPorId(Integer id);

    /**
     * Obtiene un producto por su nombre
     */
    Optional<ProductoDTO> obtenerPorNombre(String nombre);

    /**
     * Obtiene productos activos
     */
    List<ProductoDTO> obtenerActivos();

    /**
     * Obtiene productos por proveedor email
     */
    List<ProductoDTO> obtenerPorProveedorEmail(String email);

    /**
     * Obtiene productos con bajo stock
     */
    List<ProductoDTO> obtenerProductosBajoStock(Integer stock);

    /**
     * Crea un nuevo producto
     */
    ProductoDTO crear(ProductoDTO productoDTO);

    /**
     * Actualiza un producto existente
     */
    ProductoDTO actualizar(Integer id, ProductoDTO productoDTO);

    /**
     * Elimina un producto
     */
    void eliminar(Integer id);

    /**
     * Verifica si un producto existe
     */
    boolean existe(Integer id);
}
