package com.example.com.example.util;

import java.util.Map;

public class DiscountService {
    double priceKg;
    double startDiscount;
    double discountStep;

    public DiscountService(double startDiscount, double discountStep, double priceKg) {
        this.priceKg = priceKg;
        this.startDiscount = startDiscount;
        this.discountStep = discountStep;
    }

    public void calculateDiscount(Map<String, Double> companyTonnage) {
        double currentDiscount = this.startDiscount;
        for (Map.Entry<String, Double> entry : companyTonnage.entrySet()) {
            String companyName = entry.getKey();
            double totalAmount = entry.getValue();
            double price = totalAmount * this.priceKg;
            double finalPrice = price - (price * currentDiscount / 100);
            System.out.println(companyName + " | Общий вес: " + totalAmount + " | Цена до скидки " + price +
                    " | Скидка " + currentDiscount + "% | Итоговая стоимость: " + finalPrice);
            currentDiscount = currentDiscount - this.discountStep;
            if (currentDiscount < 0) {
                currentDiscount = 0.0;
            }
        }

    }

}
