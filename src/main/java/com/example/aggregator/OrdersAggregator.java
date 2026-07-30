package com.example.ordersAggregator;

import com.example.orders.Order;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class OrdersAggregator {
    public Map<String, Double> aggregate(ArrayList<Order> sortedOrders) {
        LinkedHashMap<String, Double> companyTonnage = new LinkedHashMap<>();

        for (Order order : sortedOrders) {
            String name = order.getOrderId();
            double amount = order.getOrderAmount();
            companyTonnage.merge(name, amount, Double::sum);
        }

        return companyTonnage;
    }
}
