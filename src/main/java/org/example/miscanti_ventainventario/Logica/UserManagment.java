package org.example.miscanti_ventainventario.Logica;

import java.util.ArrayList;
import java.util.List;

public class UserManagment {
    private static final ArrayList<Usuario> usuarios = new ArrayList<>();

    static {
        // Usuario y contraseña ficticios
        usuarios.add(new Usuario("admin","Carlos","Luis","Gonzalez","Perez","carlos.gonzalez@example.com","1234"));
        usuarios.add(new Usuario("user1","Laura","Maria","Fernandez","Ruiz","laura.fernandez@example.com","password123"));
        usuarios.add(new Usuario("user2","Juan","Carlos","Lopez","Sanchez","juan.lopez@example.com","mypassword"));
        usuarios.add(new Usuario("user3","Marta","Isabel","Diaz","Moreno","marta.diaz@example.com","marta2024"));
        usuarios.add(new Usuario("user4","David","Alejandro","Martinez","Fernandez","david.martinez@example.com","davidpass"));
        usuarios.add(new Usuario("user5","Luis","Antonio","Garcia","Lopez","luis.garcia@example.com","12345luis"));
        usuarios.add(new Usuario("user6","Paola","Elena","Perez","Hernandez","paola.perez@example.com","paola2024"));
        usuarios.add(new Usuario("user7","Ricardo","Javier","Sanchez","Vazquez","ricardo.sanchez@example.com","ricardo@2024"));
        usuarios.add(new Usuario("user8","Alba","Rosa","Castro","Jimenez","alba.castro@example.com","alba12345"));
        usuarios.getFirst().setRol(Rol.ADMINISTRADOR);
    }

    public static boolean isValidUser(String username, String password) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNickName().equals(username) && usuario.getContrasena().equals(password)) {
                return true;
            }
        }
        return false;
    }
    public static Usuario getUser(String username, String password) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNickName().equals(username) && usuario.getContrasena().equals(password)) {
                return usuario;
            }
        }
        return null;
    }

    public static boolean addUser(Usuario usuario){
        return usuarios.add(usuario);
    }

    public static List<Usuario> obtenerUsuarios() {
        return usuarios;
    }

    public static Usuario obtenerUsuario(String usuario) {
        for (Usuario usuario1 : usuarios) {
            if (usuario1.getNickName().equals(usuario)) {
                return usuario1;
            }
        }
        return null;
    }
}
