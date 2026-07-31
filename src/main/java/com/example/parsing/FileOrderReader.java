package com.example.parsing;

import com.example.model.Order;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

public class FileOrderReader implements OrderReader {

    @Override
    public List<Order> read(String file) {
        List<Order> orders = new ArrayList<>();
        Adapter adapter = new Adapter();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String string = "";
            while ((string = reader.readLine()) != null) {
                Order order = adapter.parse(string);
                if (order != null) {
                    orders.add(order);
                }
            }
        } catch (IOException e) {
        }
        return orders;
    }
}


