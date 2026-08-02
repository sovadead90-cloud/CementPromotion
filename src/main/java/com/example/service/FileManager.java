package com.example.service;

import com.example.model.Order;
import com.example.model.OrderInvoice;
import com.example.parsing.OrderParser;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    public List<Order> read(String file, OrderParser parser) {
        InputStream is = getClass().getClassLoader().getResourceAsStream(file);
        List<Order> orders = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            String string = "";
            while ((string = reader.readLine()) != null) {
                Order order = parser.parse(string);
                if (order != null) {
                    orders.add(order);
                }
            }
        } catch (IOException e) {
        }
        return orders;
    }

    public void writeReportToFile(List<OrderInvoice> invoices, double totalRevenue) throws Exception {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("total.cost.txt", true))) {
            for (OrderInvoice invoice : invoices) {
                bw.write(invoice.companyName() + " - " + invoice.finalPrice());
                bw.newLine();
            }
            bw.write(" Итоговая выручка " + totalRevenue);
        }
    }
}


