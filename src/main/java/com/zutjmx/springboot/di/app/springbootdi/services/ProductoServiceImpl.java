package com.zutjmx.springboot.di.app.springbootdi.services;

import java.util.List;
import java.util.stream.Collectors;

import com.zutjmx.springboot.di.app.springbootdi.models.Producto;
import com.zutjmx.springboot.di.app.springbootdi.repositories.ProductoRepositoryImpl;

public class ProductoServiceImpl implements ProductoService {

    private ProductoRepositoryImpl productoRepository = new ProductoRepositoryImpl();

    @Override
    public List<Producto> findAllProductos() {
        return productoRepository
        .findAllProductos()
        .stream()
        .map(p -> {
            Double precioConImpuesto = p.getPrecio()*1.16d;
            Producto nuevoProducto = (Producto) p.clone();
            nuevoProducto.setPrecio(precioConImpuesto.longValue());
            return nuevoProducto;
        }).collect(Collectors.toList());
    }

    @Override
    public Producto findByIProducto(Long id) {
        return productoRepository.findByIdProducto(id);
    }

}
