package com.example.canteenapp;

public class Admin {

    private String username;
    private String password;
    private String admin_name;

    public Admin(String username, String password, String admin_name) {
        this.username = username;
        this.password = password;
        this.admin_name = admin_name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAdmin_name() {
        return admin_name;
    }

    public void setAdmin_name(String admin_name) {
        this.admin_name = admin_name;
    }
}
