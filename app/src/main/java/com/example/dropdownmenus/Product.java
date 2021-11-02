package com.example.dropdownmenus;

import androidx.annotation.Nullable;

public class Product {
    private String name;
    private int quantity;
    private double price;
    private Integer weight_per_unit;

    public Product(String name, int quantity, double price, Integer weight_per_unit) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.weight_per_unit = weight_per_unit;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public Integer getWeight_per_unit() {return weight_per_unit;}

}
