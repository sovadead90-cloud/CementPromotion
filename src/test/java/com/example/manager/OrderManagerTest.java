package com.example.manager;

import com.example.model.Order;
import com.example.model.OrderInvoice;
import com.example.service.FileManager;
import com.example.util.DiscountService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;

@ExtendWith(MockitoExtension.class)

class OrderManagerTest {
    @Mock
    private FileManager fileManager;
    @Mock
    private DiscountService discountService;
    @InjectMocks
    private OrderManager orderManager;
    @Test
    void manage_shouldCallAllServicesInOrder()   {
        List<Order> fakeOrders = List.of(new Order("Prestige", 9520.0, LocalDateTime.now()));
        List<OrderInvoice> fakeInvoices = List.of(new OrderInvoice("Prestige", 9520.0));
        Mockito.when(fileManager.read(Mockito.anyString(), Mockito.any())).thenReturn(fakeOrders);
        Mockito.when(discountService.calculateDiscount(Mockito.anyList(),
                Mockito.anyDouble(), Mockito.anyDouble(), Mockito.anyDouble())).thenReturn(fakeInvoices);
            orderManager.manage(9.0, 70.0, 3.0);
            Mockito.verify(fileManager).read(Mockito.anyString(), Mockito.any());
            Mockito.verify(discountService).calculateDiscount(Mockito.anyList(),
                    Mockito.anyDouble(), Mockito.anyDouble(), Mockito.anyDouble());
            Mockito.verify(fileManager).writeReportToFile(Mockito.any(), Mockito.anyDouble());
    }
}