package com.example.mvc_final_cs281.model;
public class Stock {
    private String name;
    private double openingPrice;
    private double closingPrice;
    public Stock(String name, double openingPrice, double closingPrice) {
        this.name = name;
        this.openingPrice = openingPrice;
        this.closingPrice = closingPrice;
    }
    public String getName(){
        return name;
    }
    public double getOpeningPrice() {
        return openingPrice;
    }
    public double getClosingPrice(){
        return closingPrice;
    }
}
