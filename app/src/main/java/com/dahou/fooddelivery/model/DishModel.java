package com.dahou.fooddelivery.model;

public class DishModel {
    private String name,category,address;
    private int image;
    private boolean state;

    public DishModel(String name, String category, String address, int image, boolean state) {
        this.name = name;
        this.category = category;
        this.address = address;
        this.image = image;
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getAddress() {
        return address;
    }

    public int getImage() {
        return image;
    }

    public boolean isState() {
        return state;
    }
}
