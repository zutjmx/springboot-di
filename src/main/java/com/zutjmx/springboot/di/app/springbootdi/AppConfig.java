package com.zutjmx.springboot.di.app.springbootdi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.zutjmx.springboot.di.app.springbootdi.repositories.ProductRepositoryJson;
import com.zutjmx.springboot.di.app.springbootdi.repositories.ProductoRepository;

@Configuration
@PropertySource("classpath:config.properties")
public class AppConfig {

    @Bean
    ProductoRepository productoRepositoryJson() {
        return new ProductRepositoryJson();
    }

}
