package org.example.demojdbc.repository;

import java.util.List;

import org.example.demojdbc.model.Producto;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ProductoRepository {
    private final JdbcTemplate plantilla;

    public ProductoRepository(JdbcTemplate plantilla) {
        this.plantilla = plantilla;
    }

    @Transactional
    public void insertar(Producto producto) {
        plantilla.update("INSERT INTO producto (nombre, precio) VALUES (?, ?)",
                producto.getNombre(), producto.getPrecio());
    }

    public List<Producto> buscarTodos() {
        return plantilla.query("SELECT * FROM producto", new ProductoMapper());
    }

    public Producto buscarUno(String nombre) {
        List<Producto> resultados = plantilla.query(
                "SELECT * FROM producto WHERE nombre = ?",
                new ProductoMapper(),
                nombre
        );
        if (resultados.isEmpty()) {
            System.out.println("No se encontró ningún producto con nombre: " + nombre);
            return null;
        } else {
            return resultados.get(0);
        }
    }

    @Transactional
    public void borrar(Producto producto) {
        plantilla.update("DELETE FROM producto WHERE nombre = ?", producto.getNombre());
    }

    @Transactional
    public void borrarTodos() {
        plantilla.update("DELETE FROM producto");
    }
}

