package org.example.demojdbc.model;

import lombok.Data;

@Data

public class Producto {
    private int id;
    private String nombre;
    private String precio;

    public Producto() {
    }

    public Producto(String nombre, String precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public Producto(String nombre) {
        this.nombre = nombre;
    }
}

