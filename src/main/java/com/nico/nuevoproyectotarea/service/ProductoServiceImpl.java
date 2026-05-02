package com.nico.nuevoproyectotarea.service;

import com.nico.nuevoproyectotarea.dto.ProductoDTO;
import com.nico.nuevoproyectotarea.entity.Producto;
import com.nico.nuevoproyectotarea.mapper.ProductoMapper;
import com.nico.nuevoproyectotarea.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Implementación del servicio de Productos
 * Sigue los principios SOLID: Single Responsibility, Dependency Inversion
 */
@Service
@Transactional
public class ProductoServiceImpl implements IProductoService {

    private final ProductoRepository productoRepository;
    private final ProductoMapper productoMapper;

    @Autowired
    public ProductoServiceImpl(ProductoRepository productoRepository, ProductoMapper productoMapper) {
        this.productoRepository = productoRepository;
        this.productoMapper = productoMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductoDTO> obtenerTodos() {
        return productoRepository.findAll()
                .stream()
                .map(productoMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ProductoDTO> obtenerPorId(Integer id) {
        return productoRepository.findById(id)
                .map(productoMapper::toDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ProductoDTO> obtenerPorNombre(String nombre) {
        return productoRepository.findByNombre(nombre)
                .map(productoMapper::toDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductoDTO> obtenerActivos() {
        return productoRepository.findByActivo(1)
                .stream()
                .map(productoMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductoDTO> obtenerPorProveedorEmail(String email) {
        return productoRepository.findByProveedorEmail(email)
                .stream()
                .map(productoMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductoDTO> obtenerProductosBajoStock(Integer stock) {
        return productoRepository.findByStockLessThan(stock)
                .stream()
                .map(productoMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProductoDTO crear(ProductoDTO productoDTO) {
        Producto producto = productoMapper.toEntity(productoDTO);
        Producto productoGuardado = productoRepository.save(producto);
        return productoMapper.toDTO(productoGuardado);
    }

    @Override
    public ProductoDTO actualizar(Integer id, ProductoDTO productoDTO) {
        Optional<Producto> productoOptional = productoRepository.findById(id);

        if (!productoOptional.isPresent()) {
            throw new RuntimeException("Producto no encontrado con ID: " + id);
        }

        Producto producto = productoOptional.get();
        producto = productoMapper.updateEntityFromDTO(productoDTO, producto);
        Producto productoActualizado = productoRepository.save(producto);

        return productoMapper.toDTO(productoActualizado);
    }

    @Override
    public void eliminar(Integer id) {
        if (!productoRepository.existsById(id)) {
            throw new RuntimeException("Producto no encontrado con ID: " + id);
        }
        productoRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existe(Integer id) {
        return productoRepository.existsById(id);
    }
}
