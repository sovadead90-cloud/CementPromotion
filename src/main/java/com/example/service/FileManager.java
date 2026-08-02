package com.example.service;

import com.example.model.Order;
import com.example.model.OrderInvoice;
import com.example.parsing.OrderParser;
import com.example.parsing.exception.IncorrectFileFormatException;

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
                try {
                    Order order = parser.parse(string);
                    orders.add(order);
                } catch (IncorrectFileFormatException e) {
                    System.err.println("Пропущена строка " + string);
                }
            }
        } catch (IOException e) {
            throw  new IncorrectFileFormatException("Ошибка чтения" +  e.getMessage());
        }
        return orders;
    }



    public void writeReportToFile(List<OrderInvoice> invoices, double totalRevenue) throws IncorrectFileFormatException {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("total.cost.txt", true))) {
            for (OrderInvoice invoice : invoices) {
                bw.write(invoice.companyName() + " - " + invoice.finalPrice());
                bw.newLine();
            }
        }
        catch (IOException e) {
            throw new IncorrectFileFormatException("Ошибка записи в файл" +  e.getMessage());
        }
    }
}


