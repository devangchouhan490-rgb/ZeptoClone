package com.example.zepto;

public class Order {

    String name;
    String status;
    int image;

    public Order(String name, String status, int image) {
        this.name = name;
        this.status = status;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public int getImage() {
        return image;
    }
}