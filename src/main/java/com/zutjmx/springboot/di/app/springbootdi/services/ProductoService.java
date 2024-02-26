package com.zutjmx.springboot.di.app.springbootdi.services;

import java.util.List;

import com.zutjmx.springboot.di.app.springbootdi.models.Producto;

public interface ProductoService {
    List<Producto> findAllProductos();
    Producto findByIProducto(Long id);
}
