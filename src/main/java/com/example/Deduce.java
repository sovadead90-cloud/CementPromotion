import com.example.manager.OrderManager;
import com.example.parsing.FileOrderReader;
import com.example.parsing.OrderReader;
import com.example.service.RevenueCalculator;
import com.example.writer.InvoicesFileWriter;

public void main(String[] args) throws Exception {

    OrderReader reader = new FileOrderReader();
    RevenueCalculator calculator = new RevenueCalculator();
    InvoicesFileWriter fileWriter = new InvoicesFileWriter();
    OrderManager manager = new OrderManager(reader, calculator, fileWriter);
    manager.manage();
}