package com.example.aggregator;

import com.example.invoice.OrderInvoice;
import com.example.orders.Order;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class OrdersAggregator {
    public List<OrderInvoice> aggregate(List<Order> orderInvoice) {
        LinkedHashMap<String, Double> companyTonnage = new LinkedHashMap<>();

        for (Order order : orderInvoice) {
            String name = order.orderId();
            double amount = order.orderAmount();
            companyTonnage.merge(name, amount, Double::sum);
        }
        List<OrderInvoice> invoices = new ArrayList<>();
        for (Map.Entry<String, Double> entry : companyTonnage.entrySet()) {
            String name = entry.getKey();
            double weight = entry.getValue();
            double amount = entry.getValue() * 3.0;
            invoices.add(new OrderInvoice(name, amount, weight ));
        }

        return invoices;
    }
}
