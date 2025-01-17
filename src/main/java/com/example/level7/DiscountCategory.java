package com.example.level7;

public enum DiscountCategory {
    국가유공자(0.1),
    군인(0.05),
    학생(0.03),
    일반인(0);

    private final double discountRate;

    DiscountCategory(double discountRate) {
        this.discountRate = discountRate;
    }

    public double getDiscountRate() {
        return discountRate;
    }
}