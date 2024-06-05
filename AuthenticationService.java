package com.portfolio.auth;

import java.util.HashMap;
import java.util.Map;

public class AuthenticationService {
    private Map<String, String> users;

    public AuthenticationService() {
        users = new HashMap<>();
        // Add default user
        users.put("user", "password");
    }

    public boolean login(String username, String password) {
        return users.containsKey(username) && users.get(username).equals(password);
    }

    public void register(String username, String password) {
        users.put(username, password);
    }
}
