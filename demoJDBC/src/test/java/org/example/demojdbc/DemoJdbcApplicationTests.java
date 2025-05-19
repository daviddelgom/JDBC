package org.example.demojdbc;

import org.example.demojdbc.model.Producto;
import org.example.demojdbc.repository.ProductoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Sql({"/schema.sql"})
class DemoJdbcApplicationTests {

    @Autowired
    ProductoRepository repositorio;

    @Test
    void borrarTodos() {
        repositorio.borrarTodos();
        List<Producto> lista = repositorio.buscarTodos();
        assertEquals(0, lista.size());
    }

    @Test
    void insertarProducto() {
        repositorio.borrarTodos();
        repositorio.insertar(new Producto("pedro", "12.99"));
        repositorio.insertar(new Producto("javier", "20.50"));
        List<Producto> lista = repositorio.buscarTodos();
        assertEquals(2, lista.size());
    }

    @Test
    void buscarTodos() {
        repositorio.borrarTodos();
        repositorio.insertar(new Producto("pedro", "12.99"));
        repositorio.insertar(new Producto("javier", "20.50"));
        List<Producto> lista = repositorio.buscarTodos();
        assertEquals(2, lista.size());
    }

    @Test
    void borrarProducto() {
        repositorio.borrarTodos();
        repositorio.insertar(new Producto("pedro", "12.99"));
        repositorio.insertar(new Producto("javier", "20.50"));
        repositorio.borrar(new Producto("pedro")); // Solo necesita el nombre
        List<Producto> lista = repositorio.buscarTodos();
        assertEquals(1, lista.size());
    }

    @Test
    void buscarUno() {
        repositorio.borrarTodos();
        repositorio.insertar(new Producto("javier", "20.50"));
        Producto producto = repositorio.buscarUno("javier");
        assertEquals("javier", producto.getNombre());
    }
}
