package com.example.parser;

import com.example.orders.Order;

import java.time.LocalDateTime;

public class OrderParser {
    public Order parseLine(String line) {
        String[] pieces = line.split("[\\|]");
        if (pieces.length < 3)  {
            return null;
        }
        LocalDateTime dateTime = LocalDateTime.parse(pieces[0]);
        double orderAmount = Double.parseDouble(pieces[2]);
        return new Order(pieces[1], orderAmount, dateTime);
    }
}
