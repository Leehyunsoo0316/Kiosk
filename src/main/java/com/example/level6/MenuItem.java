package com.example.level6;

public class MenuItem {
    // 필드
    private String name; // 메뉴 이름
    private double price; // 메뉴 가격
    private String explanation; // 메뉴 설명

    // 생성자
    public MenuItem (String name, double price, String explanation) {
        this.name = name;
        this.price = price;
        this.explanation = explanation;
    }

    // 메서드
    // 메뉴 이름 getter
    public String getName () {
        return name;
    }

    // 메뉴 가격 getter
    public double getPrice () {
        return price;
    }

    // 메뉴 설명 getter
    public String getExplanation () {
        return explanation;
    }

    // 메뉴 이름 setter
    public void setName (String name) {
        this.name = name;
    }

    // 메뉴 이름 setter
    public void setPrice (double price) {
        this.price = price;
    }

    // 메뉴 이름 setter
    public void setExplanation (String explanation) {
        this.explanation = explanation;
    }

    @Override
    public String toString() {
        if (getPrice() == 0) {
            return String.format("%s | %s", name, explanation);
        } else {
        return String.format("%s | W %.1f | %s", name, price, explanation);
        }
    }
}
