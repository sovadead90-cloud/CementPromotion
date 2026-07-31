package com.example.service;

import com.example.com.example.util.DiscountService;
import com.example.parsing.FileOrderReader;
import com.example.parsing.OrderReader;
import com.example.model.OrderInvoice;
import com.example.model.Order;
import com.example.writer.InvoicesFileWriter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OrderManager {
    public void manage() throws Exception {
        double startDiscount = 50.0;
        double discountStep = 5.0;
        List<Order> allOrders = new ArrayList<>();
        OrderReader reader = new FileOrderReader();
        allOrders.addAll(reader.read("discount_day.txt"));
        allOrders.sort(Comparator.comparing(Order::orderDate));
        DiscountService discountService = new DiscountService();
        List<OrderInvoice> invoices = discountService.calculateDiscount(allOrders, startDiscount, discountStep);
        RevenueCalculator calculator = new RevenueCalculator();
        double finalMoney = calculator.calculateTotalRevenue(invoices);
        InvoicesFileWriter fileWriter = new InvoicesFileWriter();
        fileWriter.writeReportToFile(invoices, finalMoney);
    }
}
