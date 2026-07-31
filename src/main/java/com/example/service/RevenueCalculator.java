package com.example.service;

import com.example.model.OrderInvoice;

import java.util.List;


public class RevenueCalculator {
    public double calculateTotalRevenue(List<OrderInvoice> invoices) {
        double total = 0.0;
        for (OrderInvoice invoice : invoices) {
            total += invoice.finalPrice();
        }
        return total;
    }
}
