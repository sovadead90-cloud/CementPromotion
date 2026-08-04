package com.example.parsing;

import com.example.model.Order;

public class OrderParserAdapter implements OrderParser {
    OrderParserImpl orderParserImpl = new OrderParserImpl();

    public Order parse(String line) {
        String adapter = line.replace('#', '|');
        return orderParserImpl.parse(adapter);
    }
}
