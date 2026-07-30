package com.example.adapter;

import com.example.orders.Order;
import com.example.parser.OrderParser;

public class Adapter {
    OrderParser orderParser = new OrderParser();
    public Order parse(String line) {
        String adapter = line.replace('#', '|');
        return orderParser.parseLine(adapter);
    }
}
