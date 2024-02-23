package com.zutjmx.springboot.di.app.springbootdi.models;

public class Producto {
    private Long id;
    
    private String nombre;
    
    private Long precio;

    public Long getId() {
        return id;
    }
    
    public Producto() {
    }

    public Producto(Long id, String nombre, Long precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public Long getPrecio() {
        return precio;
    }
    
    public void setPrecio(Long precio) {
        this.precio = precio;
    }

}
