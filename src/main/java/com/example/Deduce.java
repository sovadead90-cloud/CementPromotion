import com.example.com.example.util.DiscountService;
import com.example.com.example.util.RevenueCalculator;
import com.example.invoice.OrderInvoice;
import com.example.file.OrderReader;
import com.example.orders.Order;
import com.example.file.FileOrderReader;
import com.example.aggregator.OrdersAggregator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public void main(String[] args) {
    ArrayList<Order> allOrders = new ArrayList<>();
    OrderReader reader = new FileOrderReader();
    allOrders.addAll(reader.read("discount_day.txt"));
    allOrders.sort(Comparator.comparing(Order::orderDate));

    for (Order order : allOrders) {
        System.out.println(order);
    }
    DiscountService discountService = new DiscountService(70.0, 2.0);
    OrdersAggregator aggregator = new OrdersAggregator();
    List<OrderInvoice> invoices = aggregator.aggregate(allOrders);
    discountService.calculateDiscount(invoices);
    RevenueCalculator calculator = new RevenueCalculator();
    double finalMoney = calculator.calculateTotalRevenue(invoices);

}