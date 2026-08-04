package com.example.model;

import java.time.LocalDateTime;

public record Order(String companyName, double orderAmount, LocalDateTime orderDate) {

    public Order(String companyName, double orderAmount, LocalDateTime orderDate) {
        this.companyName = companyName;
        this.orderAmount = orderAmount;
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return orderDate + " | " + companyName + " | " + orderAmount;
    }
}