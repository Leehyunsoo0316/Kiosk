package com.example.level3;

public class MenuItem {
    // 필드
    private String name;
    private double price;
    private String explanation;

    public MenuItem (String name, double price, String explanation) {
        this.name = name;
        this.price = price;
        this.explanation = explanation;
    }

    public String getName () {
        return name;
    }

    public double getPrice () {
        return price;
    }

    public String getExplanation () {
        return explanation;
    }
}