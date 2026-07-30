package com.example.com.example.util;

import com.example.invoice.OrderInvoice;

import java.util.List;

public class DiscountService {
    double startDiscount;
    double discountStep;

    public DiscountService(double startDiscount, double discountStep) {
        this.startDiscount = startDiscount;
        this.discountStep = discountStep;
    }

    public void calculateDiscount(List<OrderInvoice> invoices) {
        double currentDiscount = this.startDiscount;
        for (OrderInvoice invoice : invoices) {
            String companyName = invoice.getCompanyName();
            double totalAmount = invoice.getTotalWeight();
            double price = invoice.getFinalAmount();
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
