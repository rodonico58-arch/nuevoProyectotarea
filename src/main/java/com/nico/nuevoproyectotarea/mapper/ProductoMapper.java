package com.nico.nuevoproyectotarea.mapper;

import com.nico.nuevoproyectotarea.dto.ProductoDTO;
import com.nico.nuevoproyectotarea.entity.Producto;
import org.springframework.stereotype.Component;

@Component
public class ProductoMapper {

    /**
     * Convierte una entidad Producto a ProductoDTO
     */
    public ProductoDTO toDTO(Producto producto) {
        if (producto == null) {
            return null;
        }

        ProductoDTO dto = new ProductoDTO();
        dto.setIdProducto(producto.getIdProducto());
        dto.setNombre(producto.getNombre());
        dto.setPrecio(producto.getPrecio());
        dto.setStock(producto.getStock());
        dto.setProveedorEmail(producto.getProveedorEmail());
        dto.setActivo(producto.getActivo());

        return dto;
    }

    /**
     * Convierte un ProductoDTO a entidad Producto
     */
    public Producto toEntity(ProductoDTO dto) {
        if (dto == null) {
            return null;
        }

        Producto producto = new Producto();
        producto.setIdProducto(dto.getIdProducto());
        producto.setNombre(dto.getNombre());
        producto.setPrecio(dto.getPrecio());
        producto.setStock(dto.getStock());
        producto.setProveedorEmail(dto.getProveedorEmail());
        producto.setActivo(dto.getActivo());

        return producto;
    }

    /**
     * Actualiza una entidad Producto con datos de un ProductoDTO
     */
    public Producto updateEntityFromDTO(ProductoDTO dto, Producto producto) {
        if (dto == null) {
            return producto;
        }

        producto.setNombre(dto.getNombre());
        producto.setPrecio(dto.getPrecio());
        producto.setStock(dto.getStock());
        producto.setProveedorEmail(dto.getProveedorEmail());
        producto.setActivo(dto.getActivo());

        return producto;
    }
}
