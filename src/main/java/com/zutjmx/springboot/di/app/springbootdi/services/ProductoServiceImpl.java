package com.zutjmx.springboot.di.app.springbootdi.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zutjmx.springboot.di.app.springbootdi.models.Producto;
import com.zutjmx.springboot.di.app.springbootdi.repositories.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService {

    private ProductoRepository productoRepository;

    //Si se inyecta el repositorio vía el constructor no es necesaria la anotación @Autowired
    public ProductoServiceImpl(@Qualifier("productoRepoImpl") ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

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
           /*  p.setPrecio(precioConImpuesto.longValue());
            return p; */
        }).collect(Collectors.toList());
    }

    @Override
    public Producto findByIProducto(Long id) {
        return productoRepository.findByIdProducto(id);
    }

    // @Autowired
    // public void setProductoRepository(ProductoRepository productoRepository) {
    //     this.productoRepository = productoRepository;
    // }

}
