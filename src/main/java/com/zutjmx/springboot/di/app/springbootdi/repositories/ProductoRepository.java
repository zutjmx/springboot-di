package com.zutjmx.springboot.di.app.springbootdi.repositories;

import java.util.List;

import com.zutjmx.springboot.di.app.springbootdi.models.Producto;

public interface ProductoRepository {
    List<Producto> findAllProductos();
    Producto findByIdProducto(Long id);
}
