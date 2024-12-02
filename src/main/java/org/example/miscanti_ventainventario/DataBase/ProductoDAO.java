package org.example.miscanti_ventainventario.DataBase;

import org.example.miscanti_ventainventario.Logica.Producto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductoDAO {

    // URL, usuario y contraseña para la conexión a la base de datos
    private static final String URL = "jdbc:mysql://localhost:3306/miscanti";
    private static final String USUARIO = "root";
    private static final String CONTRASENA = "";

    // Método para añadir un producto en la base de datos
    public boolean anadirProducto(Producto producto) {
        String sql = "INSERT INTO productos (codigo, nombre, cantidad, precio) VALUES (?, ?, ?, ?)";
        try (Connection conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
             PreparedStatement stmt = conexion.prepareStatement(sql)) {

            stmt.setInt(1, producto.getCodigo());
            stmt.setString(2, producto.getNombre());
            stmt.setInt(3, producto.getCantidad());
            stmt.setInt(4, producto.getPrecio());

            int filasInsertadas = stmt.executeUpdate();
            return filasInsertadas > 0; // Retorna true si se insertó al menos una fila

        } catch (SQLException e) {
            System.err.println("Error al guardar el producto: " + e.getMessage());
            return false;
        }
    }

    // Método para actualizar un producto existente en la base de datos
    public boolean actualizarProducto(int codigo, String nuevoNombre, int nuevaCantidad, int nuevoPrecio) {
        String sql = "UPDATE productos SET nombre = ?, cantidad = ?, precio = ? WHERE codigo = ?";
        try (Connection conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            // Configurar los parámetros
            ps.setString(1, nuevoNombre);
            ps.setInt(2, nuevaCantidad);
            ps.setInt(3, nuevoPrecio);
            ps.setInt(4, codigo);

            // Ejecutar la actualización
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0; // Retorna true si se actualizó al menos una fila

        } catch (SQLException e) {
            System.err.println("Error al actualizar el producto: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminarProducto(int codigo) {
        String sql = "DELETE FROM productos WHERE codigo = ?";
        try (Connection conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setInt(1, codigo);

            int filasEliminadas = ps.executeUpdate();
            return filasEliminadas > 0;

        } catch (SQLException e) {
            System.err.println("Error al eliminar el producto: " + e.getMessage());
            return false;
        }
    }

}
