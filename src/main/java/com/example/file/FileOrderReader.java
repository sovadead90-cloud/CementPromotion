package com.example.fileOrderReader;

import com.example.orderReader.OrderReader;
import com.example.orders.Order;
import com.example.orderParser.OrderParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileOrderReader implements OrderReader {

    @Override
    public ArrayList<Order> read(String file) {
        ArrayList<Order> orders = new ArrayList<>();
        OrderParser orderParser = new OrderParser();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String string = "";
            while ((string = reader.readLine()) != null) {
                Order order = orderParser.parseLine(string);
                if (order != null) {
                    orders.add(order);
                }
            }
        } catch (IOException e) {
        }
        return orders;
    }
}


