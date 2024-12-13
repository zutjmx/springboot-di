package com.zutjmx.springboot.di.app.springbootdi.repositories;

import java.util.Arrays;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zutjmx.springboot.di.app.springbootdi.models.Producto;

public class ProductRepositoryJson implements ProductoRepository {

    private List<Producto> productos;

    public ProductRepositoryJson() {
        Resource resource = new ClassPathResource("json/producto.json");
        ObjectMapper mapper = new ObjectMapper();
        productos = Arrays.asList(mapper.readValue(resource.getFile());
    }

    @Override
    public List<Producto> findAllProductos() {
        throw new UnsupportedOperationException("Unimplemented method 'findAllProductos'");
    }

    @Override
    public Producto findByIdProducto(Long id) {
        throw new UnsupportedOperationException("Unimplemented method 'findByIdProducto'");
    }

}
