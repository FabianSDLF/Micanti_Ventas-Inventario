package org.example.miscanti_ventainventario.DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/miscanti"; // Cambia 'inventario' por tu BD
    private static final String USERNAME = "root"; // Usuario predeterminado
    private static final String PASSWORD = ""; // Contraseña predeterminada (vacía)

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}


