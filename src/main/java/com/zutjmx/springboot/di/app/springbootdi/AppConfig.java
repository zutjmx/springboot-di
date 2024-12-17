package com.zutjmx.springboot.di.app.springbootdi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;

import com.zutjmx.springboot.di.app.springbootdi.repositories.ProductRepositoryJson;
import com.zutjmx.springboot.di.app.springbootdi.repositories.ProductoRepository;

@Configuration
@PropertySource("classpath:config.properties")
public class AppConfig {

    @Value("classpath:json/producto.json")
    private Resource resource;

    @Bean
    ProductoRepository productoRepositoryJson() {
        return new ProductRepositoryJson(resource);
    }

}
