package com.example.com.example.util;

import com.example.invoice.OrderInvoice;

import java.util.List;

public class RevenueCalculator {
    public double calculateTotalRevenue(List<OrderInvoice> invoices) {
        double total = 0.0;
        double currentDiscount = 100.0;
        for (OrderInvoice invoice : invoices) {
            double price = invoice.getFinalAmount();
            double discount = price - (price * currentDiscount / 100);
            total += discount;
            currentDiscount -= 10.0;
            if (currentDiscount < 0) {
                currentDiscount = 0.0;
            }
        }
        return total;
    }
}
