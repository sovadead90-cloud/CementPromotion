package com.example.parsing;

import com.example.model.Order;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileOrderReader implements OrderReader {

    @Override
    public List<Order> read(String file) {
        InputStream is = getClass().getClassLoader().getResourceAsStream(file);
        List<Order> orders = new ArrayList<>();
        Adapter adapter = new Adapter();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
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


