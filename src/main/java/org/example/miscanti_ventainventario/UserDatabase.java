package org.example.miscanti_ventainventario;

import java.util.HashMap;
import java.util.Map;

public class UserDatabase {
    private static final Map<String, String> USERS = new HashMap<>();

    static {
        // Usuario y contraseña ficticios
        USERS.put("admin", "1234");
        USERS.put("user", "password");
    }

    public static boolean isValidUser(String username, String password) {
        return USERS.containsKey(username) && USERS.get(username).equals(password);
    }
}
