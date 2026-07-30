package com.example.orders;

import java.time.LocalDateTime;

public class Order {
    String orderId;
    double orderAmount;
    LocalDateTime orderDate;

    public Order(String orderId, double orderAmount, LocalDateTime orderDate) {
        this.orderId = orderId;
        this.orderAmount = orderAmount;
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return orderDate + " | " + orderId + " | " + orderAmount;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public String getOrderId() {
        return orderId;
    }

    public double getOrderAmount() {
        return orderAmount;
    }
}