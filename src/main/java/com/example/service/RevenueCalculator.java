package com.example.service;

import com.example.model.OrderInvoice;

import java.util.List;


public class RevenueCalculator {
    public double calculateTotalRevenue(List<OrderInvoice> invoices) {
        return invoices.stream().mapToDouble(OrderInvoice::finalPrice).sum();
    }
}
