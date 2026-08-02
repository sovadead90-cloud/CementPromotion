package com.example.parsing;

import com.example.model.Order;

public interface OrderParser {
    Order parse (String line);
}
