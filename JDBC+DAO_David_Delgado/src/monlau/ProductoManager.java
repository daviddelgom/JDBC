package monlau;

import monlau.dao.ProductoDAO;
import monlau.dao.ProductoDAOImpl;
import monlau.model.Producto;

public class ProductoManager {
    public static void main(String[] args) {
        ProductoDAO productoDAO = new ProductoDAOImpl();


        Producto nuevoProducto = new Producto(200, "Pollo", 10.0);
        productoDAO.insert(nuevoProducto);
        System.out.println("Producto insertado: " + nuevoProducto);


        Producto productoLeido = productoDAO.read(200);
        if (productoLeido != null) {
            System.out.println("Producto leído: " + productoLeido);
        } else {
            System.out.println("Producto con ID 200 no encontrado.");
        }


        if (productoLeido != null) {
            productoLeido.setNombre("Pollo Asado");
            productoLeido.setPrecio(12.5);
            productoDAO.update(productoLeido);
            Producto productoActualizado = productoDAO.read(200);
            System.out.println("Producto actualizado: " + productoActualizado);
        }


        if (productoLeido != null) {
            productoDAO.delete(productoLeido);
            System.out.println("Producto eliminado.");
        }


        Producto productoEliminado = productoDAO.read(200);
        if (productoEliminado == null) {
            System.out.println("Producto con ID 200 no se encuentra (eliminado).");
        } else {
            System.out.println("Error: el producto todavía existe: " + productoEliminado);
        }
    }
}
