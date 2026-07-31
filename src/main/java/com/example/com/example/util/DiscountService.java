package com.example.com.example.util;

import com.example.model.OrderInvoice;
import com.example.model.Order;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DiscountService {
    public List<OrderInvoice> calculateDiscount(List<Order> invoices, double startDiscount, double discountStep) {
        List<OrderInvoice> readyInvoices = new ArrayList<>();
        LinkedHashMap<String, Double> companyTonnage = new LinkedHashMap<>();

        for (Order order : invoices) {
            String name = order.orderId();
            double amount = order.orderAmount();
            companyTonnage.merge(name, amount, Double::sum);
        }
        double currentDiscount = startDiscount;
        for (Map.Entry<String, Double> entry : companyTonnage.entrySet()) {
            String companyName = entry.getKey();
            double totalAmount = entry.getValue();
            double price = totalAmount * 4.0;
            double finalPrice = price - (price * currentDiscount / 100);
            System.out.println(companyName + " | Общий вес: " + totalAmount + " | Цена до скидки " + price +
                    " | Скидка " + currentDiscount + "% | Итоговая стоимость: " + finalPrice);
            readyInvoices.add(new OrderInvoice(companyName, finalPrice));
            currentDiscount = currentDiscount - discountStep;
            if (currentDiscount < 0) {
                currentDiscount = 0.0;
            }
        }
        return readyInvoices;
    }
}
