package service;

public class Auth {
    public boolean login(String username, String password) {
        return username.equals("admin") && password.equals("admin");
    }
}
