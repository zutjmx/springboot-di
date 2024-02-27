package com.zutjmx.springboot.di.app.springbootdi.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Repository;

import com.github.javafaker.Faker;
import com.zutjmx.springboot.di.app.springbootdi.models.Producto;

@Repository("productoRepoAux")
public class ProductoRepositoryAux implements ProductoRepository {

    @Override
    public List<Producto> findAllProductos() {
        return generaGot();
    }

    @Override
    public Producto findByIdProducto(Long id) {
        return generaUnGot(id);
    }

    private List<Producto> generaGot() {
        Faker faker = new Faker(Locale.getDefault());
        List<Producto> productos = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Producto producto = new Producto();
            producto.setId(faker.number().randomNumber());
            producto.setNombre(faker.gameOfThrones().character());
            producto.setPrecio(faker.number().randomNumber());
            productos.add(producto);
        }
        return productos;
    }

    private Producto generaUnGot(Long id) {
        Faker faker = new Faker(Locale.getDefault());
        Producto producto = new Producto();
        producto.setId(id);
        producto.setNombre(faker.gameOfThrones().character());
        producto.setPrecio(faker.number().randomNumber());
        return producto;
    }

}
