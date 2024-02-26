package com.zutjmx.springboot.di.app.springbootdi.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zutjmx.springboot.di.app.springbootdi.models.Producto;
import com.zutjmx.springboot.di.app.springbootdi.repositories.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

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
