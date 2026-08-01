package com.example.manager;

import com.example.service.RevenueCalculator;
import com.example.util.DiscountService;
import com.example.parsing.FileOrderReader;
import com.example.parsing.OrderReader;
import com.example.model.OrderInvoice;
import com.example.model.Order;
import com.example.writer.InvoicesFileWriter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OrderManager {
    private final OrderReader reader;
    private final RevenueCalculator revenueCalculator;
    private final InvoicesFileWriter fileWriter;

    public OrderManager(OrderReader reader, RevenueCalculator revenueCalculator, InvoicesFileWriter fileWriter) throws Exception {
        this.reader = reader;
        this.revenueCalculator = revenueCalculator;
        this.fileWriter = fileWriter;
    }

    public void manage() throws Exception {
        double priceKg = 4.0;
        double startDiscount = 50.0;
        double discountStep = 5.0;
        List<Order> allOrders = new ArrayList<>();
        allOrders.addAll(reader.read("discount_day_without_ext"));
        allOrders.sort(Comparator.comparing(Order::orderDate));
        DiscountService discountService = new DiscountService();
        List<OrderInvoice> invoices = discountService.calculateDiscount(allOrders, priceKg, startDiscount, discountStep);
        double finalMoney = this.revenueCalculator.calculateTotalRevenue(invoices);
        this.fileWriter.writeReportToFile(invoices, finalMoney);
    }
}
