import main.java.discountService.DiscountService;
import main.java.orders.Order;
import main.java.fileOrderReader.FileOrderReader;
import main.java.ordersAggregator.OrdersAggregator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;

public void main(String[] args) {
    ArrayList<Order> allOrders = new ArrayList<>();
    main.java.orderReader.OrderReader reader = new FileOrderReader();
    allOrders.addAll(reader.read("discount_day.txt"));
    allOrders.sort(Comparator.comparing(Order::getOrderDate));

    for(Order order : allOrders) {
        System.out.println(order);
    }
    DiscountService discountService = new DiscountService(100.0, 10.0, 3.0);
    OrdersAggregator aggregator = new OrdersAggregator();
    Map<String, Double> combinedMap = aggregator.aggregate(allOrders);
    discountService.calculateDiscount(combinedMap);
    System.out.println(combinedMap);

}