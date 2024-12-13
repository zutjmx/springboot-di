package com.zutjmx.springboot.di.app.springbootdi.services;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.zutjmx.springboot.di.app.springbootdi.models.Producto;
import com.zutjmx.springboot.di.app.springbootdi.repositories.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService {

    private ProductoRepository productoRepository;

    private Logger logger = LoggerFactory.getLogger(ProductoServiceImpl.class);

    @Autowired
    private Environment environment;

    //Si se inyecta el repositorio vía el constructor no es necesaria la anotación @Autowired
    // public ProductoServiceImpl(@Qualifier("productoRepoImpl") ProductoRepository productoRepository) {
    //     this.productoRepository = productoRepository;
    // }

    //Si se inyecta el repositorio vía el constructor no es necesaria la anotación @Autowired
    public ProductoServiceImpl(@Qualifier("productoRepositoryJson") ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public List<Producto> findAllProductos() {
        Double factorIva = environment.getProperty("config.precio.iva",Double.class);
        logger.info("factorIva: "+factorIva);
        return productoRepository
        .findAllProductos()
        .stream()
        .map(p -> {
            Double precioConImpuesto = p.getPrecio()*(factorIva==null?1d:factorIva);
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
