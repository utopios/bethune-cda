package org.example;

public class Product {
    private String type;
    private String name;
    private int sellIn;
    private double quality;

    public Product(String type, String name, int sellIn, double quality) {
        this.type = type;
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSellIn() {
        return sellIn;
    }

    public void setSellIn(int sellIn) {
        this.sellIn = sellIn;
    }

    public double getQuality() {
        return quality;
    }

    public void setQuality(double quality) {
        this.quality = quality;
    }
}