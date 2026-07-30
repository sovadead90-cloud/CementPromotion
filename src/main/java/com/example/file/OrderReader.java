package com.example.file;

import com.example.orders.Order;

import java.util.List;

public interface OrderReader {
    List<Order> read(String file);

}
