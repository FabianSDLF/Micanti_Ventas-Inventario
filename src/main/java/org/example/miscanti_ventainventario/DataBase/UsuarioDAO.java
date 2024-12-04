package org.example.miscanti_ventainventario.DataBase;

import org.example.miscanti_ventainventario.Logica.Usuario;
import org.example.miscanti_ventainventario.Logica.Rol;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsuarioDAO {

    // URL, usuario y contraseña para la conexión a la base de datos
    private static final String URL = "jdbc:mysql://localhost:3306/miscanti";
    private static final String USUARIO = "root";
    private static final String CONTRASENA = "";

    // Método para añadir un usuario a la base de datos
    public boolean agregarUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuarios (nickName, primerNombre, segundoNombre, apellidoMaterno, apellidoPaterno, correo, contrasena, rol) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
             PreparedStatement stmt = conexion.prepareStatement(sql)) {

            stmt.setString(1, usuario.getNickName());
            stmt.setString(2, usuario.getPrimerNombre());
            stmt.setString(3, usuario.getSegundoNombre());
            stmt.setString(4, usuario.getApellidoMaterno());
            stmt.setString(5, usuario.getApellidoPaterno());
            stmt.setString(6, usuario.getCorreo());
            stmt.setString(7, usuario.getContrasena());
            stmt.setString(8, usuario.getRol().name());

            int filasInsertadas = stmt.executeUpdate();
            return filasInsertadas > 0;

        } catch (SQLException e) {
            System.err.println("Error al agregar el usuario: " + e.getMessage());
            return false;
        }
    }

    // Método para actualizar un usuario
    public boolean actualizarUsuario(String nickName, String nuevoCorreo, String nuevaContrasena, Rol nuevoRol) {
        String sql = "UPDATE usuarios SET correo = ?, contrasena = ?, rol = ? WHERE nickName = ?";
        try (Connection conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
             PreparedStatement stmt = conexion.prepareStatement(sql)) {

            stmt.setString(1, nuevoCorreo);
            stmt.setString(2, nuevaContrasena);
            stmt.setString(3, nuevoRol.name());
            stmt.setString(4, nickName);

            int filasAfectadas = stmt.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            System.err.println("Error al actualizar el usuario: " + e.getMessage());
            return false;
        }
    }

    // Método para eliminar un usuario de la base de datos
    public boolean eliminarUsuario(String nickName) {
        String sql = "DELETE FROM usuarios WHERE nickName = ?";
        try (Connection conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
             PreparedStatement stmt = conexion.prepareStatement(sql)) {

            stmt.setString(1, nickName);

            int filasEliminadas = stmt.executeUpdate();
            return filasEliminadas > 0;

        } catch (SQLException e) {
            System.err.println("Error al eliminar el usuario: " + e.getMessage());
            return false;
        }
    }
}
