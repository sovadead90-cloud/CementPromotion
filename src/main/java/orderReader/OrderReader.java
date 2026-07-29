package main.java.orderReader;

import main.java.orders.Order;

import java.util.ArrayList;

public interface OrderReader {
    ArrayList<Order> read(String file);
}
