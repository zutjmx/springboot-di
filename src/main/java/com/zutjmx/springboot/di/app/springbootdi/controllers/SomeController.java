package com.zutjmx.springboot.di.app.springbootdi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zutjmx.springboot.di.app.springbootdi.models.Producto;
import com.zutjmx.springboot.di.app.springbootdi.services.ProductoService;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api")
public class SomeController {

    //@Autowired
    private ProductoService productoService;

    //Si se inyecta el servicio vía el constructor no es necesaria la anotación @Autowired
    public SomeController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping
    public List<Producto> getAllProductos() {
        return productoService.findAllProductos();
    }

    @GetMapping("/{id}")
    public Producto geByIProducto(@PathVariable Long id) {
        return productoService.findByIProducto(id);
    }
    
}
