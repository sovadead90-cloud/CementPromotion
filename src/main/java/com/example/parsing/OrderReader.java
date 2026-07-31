package com.example.parsing;

import com.example.model.Order;

import java.util.List;

public interface OrderReader {
    List<Order> read(String file);
}
