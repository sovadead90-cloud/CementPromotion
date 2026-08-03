package com.example.service;

import com.example.model.Order;
import com.example.model.OrderInvoice;
import com.example.parsing.OrderParser;
import com.example.parsing.OrderParserAdapter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;


public class FileManagerTest {
    @Test
    void read_shouldParseValidOrdersAndIgnoreErrors() {
        FileManager fileManager = new FileManager();
        OrderParser parser = new OrderParserAdapter();
        List<Order> result = fileManager.read("test_orders.txt", parser);
        Assertions.assertEquals(1, result.size());  //Проверка, что список не пустой
                                                            // и содержит один заказ, битую пропускаем
        Assertions.assertEquals("Industry Company", result.get(0).companyName());   //Имя компании
                                                                                            // прочиталось верно
        Assertions.assertEquals(9520.0, result.get(0).orderAmount());   //Проверка расчета(прочитались верно)
    }
    @Test
    void writeReportToFile_shouldSuccessfullyWriteData() {
        FileManager testfileManager = new FileManager();
        List<OrderInvoice> testInvoices = List.of(new OrderInvoice("Industry Company", 9520.0));
        new File("total.cost.txt").delete();
        testfileManager.writeReportToFile(testInvoices, 9520.0);
        Assertions.assertTrue(new File(System.getProperty("user.dir") +
                File.separator + "total.cost.txt").exists());   //Проверяем, что файл есть на диске
                                                                // и в него что-то записалось
        new File("total.cost.txt").delete();    //Удаляем полностью при завершенной проверке
    }
}