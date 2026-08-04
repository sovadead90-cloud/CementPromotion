package com.example.manager;

import com.example.parsing.OrderParserAdapter;
import com.example.service.FileManager;
import com.example.util.DiscountService;
import com.example.model.OrderInvoice;
import com.example.model.Order;

import java.util.List;

public class OrderManager {
    private final FileManager fileManager;
    private final DiscountService discountService;

    public OrderManager(FileManager fileWriter, DiscountService discountService)  {
        this.fileManager = fileWriter;
        this.discountService = discountService;
    }

    public void manage(double priceKg, double startDiscount, double discountStep)  {
        List<Order> allOrders = fileManager.read("discount_day_without_ext", new  OrderParserAdapter());
        List<OrderInvoice> invoices = discountService.calculateDiscount(allOrders, priceKg, startDiscount, discountStep);
        fileManager.writeReportToFile(invoices);
    }
}
