package com.zutjmx.springboot.di.app.springbootdi.services;

import java.util.List;
import java.util.stream.Collectors;

import com.zutjmx.springboot.di.app.springbootdi.models.Producto;
import com.zutjmx.springboot.di.app.springbootdi.repositories.ProductoRepository;

public class ProductoService {

    private ProductoRepository productoRepository = new ProductoRepository();

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

    public Producto findByIProducto(Long id) {
        return productoRepository.findByIdProducto(id);
    }

}
