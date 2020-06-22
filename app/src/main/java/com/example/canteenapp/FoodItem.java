package com.example.canteenapp;

public class FoodItem {
    private int item_id;
    private String food_name;
    private String item_desc;
    private String cost;
    private String time_to_get_ready;

    public FoodItem(int item_id, String food_name, String item_desc, String cost, String time_to_get_ready) {
        this.item_id = item_id;
        this.food_name = food_name;
        this.item_desc = item_desc;
        this.cost = cost;
        this.time_to_get_ready = time_to_get_ready;
    }

    public FoodItem(String food_name, String item_desc, String cost, String time_to_get_ready) {
        this.food_name = food_name;
        this.item_desc = item_desc;
        this.cost = cost;
        this.time_to_get_ready = time_to_get_ready;
    }

    public FoodItem() {

    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public String getFood_name() {
        return food_name;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    public String getItem_desc() {
        return item_desc;
    }

    public void setItem_desc(String item_desc) {
        this.item_desc = item_desc;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getTime_to_get_ready() {
        return time_to_get_ready;
    }

    public void setTime_to_get_ready(String time_to_get_ready) {
        this.time_to_get_ready = time_to_get_ready;
    }
}
