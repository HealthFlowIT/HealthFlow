package com.example.healthflow;

public class UserSession2 {
    private static UserSession2 instance;
    private String username;

    private UserSession2(String username) {
        this.username = username;
    }

    public static UserSession2 getInstance(String username) {
        if (instance == null) {
            instance = new UserSession2(username);
        }
        return instance;
    }

    public static UserSession2 getInstance() {
        return instance;
    }

    public String getusername() {
        return username;
    }
}