package com.example.reader;

import com.example.orders.Order;

import java.util.List;

public interface OrderReader {
    List<Order> read(String file);

}
