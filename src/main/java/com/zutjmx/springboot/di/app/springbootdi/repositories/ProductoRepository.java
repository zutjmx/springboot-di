package com.zutjmx.springboot.di.app.springbootdi.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.github.javafaker.Faker;
import com.zutjmx.springboot.di.app.springbootdi.models.Producto;

public class ProductoRepository {
    
    private List<Producto> datos;

    private Faker faker = new Faker(Locale.getDefault());

    public ProductoRepository() {
        List<Producto> productos = generaProductos();
        this.datos = productos;
    }

    public List<Producto> findAllProductos() {
        return this.datos;
    }

    public Producto findByIProducto(Long id) {
        return this.datos.stream()
        .filter(p -> p.getId().equals(id))
        .findFirst()
        .orElseThrow();
    }

    private List<Producto> generaProductos() {
        List<Producto> productos = new ArrayList<>();
        int indice = this.faker.number().numberBetween(11, 31);
        for (int i = 0; i < indice; i++) {
            Producto producto = new Producto();
            producto.setId(this.faker.number().randomNumber());
            producto.setNombre(this.faker.commerce().productName());
            producto.setPrecio(this.faker.number().randomNumber());
            productos.add(producto);
        }
        return productos;
    }

}
