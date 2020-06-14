package com.example.canteenapp;

public class Canteen {

    private String management_name;
    private String handler_name;
    private String phone_no;
    private int no_of_workers;
    private String address;
    private String username;
    private String password;

    public Canteen(String management_name, String handler_name, String phone_no, int no_of_workers, String address, String username, String password) {

        this.management_name = management_name;
        this.handler_name = handler_name;
        this.phone_no = phone_no;
        this.no_of_workers = no_of_workers;
        this.address = address;
        this.username = username;
        this.password = password;
    }


    public String getManagement_name() {
        return management_name;
    }

    public void setManagement_name(String management_name) {
        this.management_name = management_name;
    }

    public String getHandler_name() {
        return handler_name;
    }

    public void setHandler_name(String handler_name) {
        this.handler_name = handler_name;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public int getNo_of_workers() {
        return no_of_workers;
    }

    public void setNo_of_workers(int no_of_workers) {
        this.no_of_workers = no_of_workers;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
}
