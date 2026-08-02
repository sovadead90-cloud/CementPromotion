import com.example.manager.OrderManager;
import com.example.service.FileManager;
import com.example.util.DiscountService;

public void main(String[] args) throws Exception {

    FileManager fileManager = new FileManager();
    DiscountService discountService = new DiscountService();
    OrderManager manager = new OrderManager(fileManager, discountService);
    manager.manage(4.0,50.0, 5.0);
}