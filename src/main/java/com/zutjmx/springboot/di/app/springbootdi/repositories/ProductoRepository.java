package com.zutjmx.springboot.di.app.springbootdi.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.github.javafaker.Faker;
import com.zutjmx.springboot.di.app.springbootdi.models.Producto;

public class ProductoRepository {
    
    private List<Producto> datos;

    public ProductoRepository() {
        List<Producto> productos = generaProductos();
        this.datos = productos;
    }

    public List<Producto> findAllProductos() {
        return this.datos;
    }

    public Producto findByIdProducto(Long id) {
        return this.datos.stream()
        .filter(p -> p.getId().equals(id))
        .findFirst()
        .orElseThrow();
    }

    private List<Producto> generaProductos() {
        Faker faker = new Faker(Locale.getDefault());
        List<Producto> productos = new ArrayList<>();
        int indice = faker.number().numberBetween(11, 31);
        for (int i = 0; i < indice; i++) {
            Producto producto = new Producto();
            producto.setId(faker.number().randomNumber());
            producto.setNombre(faker.commerce().productName());
            producto.setPrecio(faker.number().randomNumber());
            productos.add(producto);
        }
        return productos;
    }

}
