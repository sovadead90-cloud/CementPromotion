package com.example.util;

import com.example.model.OrderInvoice;
import com.example.model.Order;

import java.util.*;
import java.util.stream.Collectors;

public class DiscountService {
    public List<OrderInvoice> calculateDiscount(List<Order> invoices, double priceKg, double startDiscount, double discountStep) {
        List<OrderInvoice> readyInvoices = new ArrayList<>();
        LinkedHashMap<String, Double> companyTonnage =
                invoices.stream().collect(Collectors.groupingBy(Order::companyName, LinkedHashMap::new,
                        Collectors.summingDouble((Order::orderAmount))));

        double currentDiscount = startDiscount;
        for (Map.Entry<String, Double> entry : companyTonnage.entrySet()) {
            String companyName = entry.getKey();
            double totalAmount = entry.getValue();
            double price = totalAmount * priceKg ;
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
