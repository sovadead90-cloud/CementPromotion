import com.example.com.example.util.DiscountService;
import com.example.orderReader.OrderReader;
import com.example.orders.Order;
import com.example.fileOrderReader.FileOrderReader;
import com.example.ordersAggregator.OrdersAggregator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;

public void main(String[] args) {
    ArrayList<Order> allOrders = new ArrayList<>();
    OrderReader reader = new FileOrderReader();
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