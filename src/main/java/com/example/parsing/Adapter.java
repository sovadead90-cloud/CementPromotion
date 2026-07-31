package com.example.parsing;

import com.example.model.Order;

public class Adapter {
    OrderParser orderParser = new OrderParser();

    public Order parse(String line) {
        String adapter = line.replace('#', '|');
        return orderParser.parseLine(adapter);
    }
}
