package com.example.canteenapp;

public class Student {

    private int id;
    private String stu_name;
    private String father_name;
    private String phone;
    private String degree_major;
    private String address;
    private String stu_id;
    private String password;
    private double balance;

    public Student() {
    }

    public Student(int id, String stu_name, String father_name, String phone, String degree_major, String address, String stu_id, String password) {
        this.id = id;
        this.stu_name = stu_name;
        this.father_name = father_name;
        this.phone = phone;
        this.degree_major = degree_major;
        this.address = address;
        this.stu_id = stu_id;
        this.password = password;
        this.balance = 0;
    }

    public Student(String stu_name, String father_name, String phone, String degree_major, String address, String stu_id, String password) {
        this.stu_name = stu_name;
        this.father_name = father_name;
        this.phone = phone;
        this.degree_major = degree_major;
        this.address = address;
        this.stu_id = stu_id;
        this.password = password;
        this.balance = 0;
    }

    public double addBalance(double balance){
        if(balance > 0){
            this.balance += balance;
        }
        return  this.balance;
    }

    public double withdraw(double withdrawAmount){
        if(!(withdrawAmount > balance)){
            balance -= withdrawAmount;
        }
        return balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStu_name() {
        return stu_name;
    }

    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
    }

    public String getFather_name() {
        return father_name;
    }

    public void setFather_name(String father_name) {
        this.father_name = father_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDegree_major() {
        return degree_major;
    }

    public void setDegree_major(String degree_major) {
        this.degree_major = degree_major;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStu_id() {
        return stu_id;
    }

    public void setStu_id(String stu_id) {
        this.stu_id = stu_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
