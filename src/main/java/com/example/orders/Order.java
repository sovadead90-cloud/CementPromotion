package com.example.orders;

import java.time.LocalDateTime;

public record Order(String orderId, double orderAmount, LocalDateTime orderDate) {

    public Order(String orderId, double orderAmount, LocalDateTime orderDate) {
        this.orderId = orderId;
        this.orderAmount = orderAmount;
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return orderDate + " | " + orderId + " | " + orderAmount;
    }
}