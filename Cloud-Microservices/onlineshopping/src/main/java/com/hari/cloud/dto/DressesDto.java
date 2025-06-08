package com.hari.cloud.dto;

public class DressesDto {

    private String brand;
    private String type;
    private String color;
    private double price;

    public DressesDto() {
    }

    public DressesDto(String brand, String type, String color, double price) {
        this.brand = brand;
        this.type = type;
        this.color = color;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
