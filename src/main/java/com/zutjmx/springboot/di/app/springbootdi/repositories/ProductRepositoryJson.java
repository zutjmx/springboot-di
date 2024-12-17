package com.zutjmx.springboot.di.app.springbootdi.repositories;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.core.io.Resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zutjmx.springboot.di.app.springbootdi.models.Producto;

public class ProductRepositoryJson implements ProductoRepository {

    private List<Producto> productos;

    public ProductRepositoryJson(Resource resource) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            productos = Arrays.asList(
                mapper.readValue(
                    resource.getInputStream(),
                    Producto[].class
                )
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Producto> findAllProductos() {
        return productos;
    }

    @Override
    public Producto findByIdProducto(Long id) {
        return productos
        .stream()
        .filter(p -> p.getId().equals(id)).findFirst().orElseThrow();
    }

}
