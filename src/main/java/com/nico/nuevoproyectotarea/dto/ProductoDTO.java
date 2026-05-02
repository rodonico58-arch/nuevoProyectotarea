package com.nico.nuevoproyectotarea.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class ProductoDTO implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private Integer idProducto;
    private String nombre;
    private BigDecimal precio;
    private Integer stock;
    private String proveedorEmail;
    private Integer activo;

    // Constructores
    public ProductoDTO() {
    }

    public ProductoDTO(Integer idProducto, String nombre, BigDecimal precio, Integer stock, String proveedorEmail, Integer activo) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.proveedorEmail = proveedorEmail;
        this.activo = activo;
    }

    // Getters y Setters
    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getProveedorEmail() {
        return proveedorEmail;
    }

    public void setProveedorEmail(String proveedorEmail) {
        this.proveedorEmail = proveedorEmail;
    }

    public Integer getActivo() {
        return activo;
    }

    public void setActivo(Integer activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "ProductoDTO{" +
                "idProducto=" + idProducto +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", stock=" + stock +
                ", proveedorEmail='" + proveedorEmail + '\'' +
                ", activo=" + activo +
                '}';
    }
}
