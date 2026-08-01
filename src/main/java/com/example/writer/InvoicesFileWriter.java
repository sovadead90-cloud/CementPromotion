package com.example.writer;

import com.example.model.OrderInvoice;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;


public class InvoicesFileWriter {
    public void writeReportToFile(List<OrderInvoice> invoices, double totalRevenue) throws Exception {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("total.cost.txt", true))) {
            for (OrderInvoice invoice : invoices) {
                bw.write(invoice.companyName() + " - " + invoice.finalPrice());
                bw.newLine();
            }
            bw.write(" Итоговая выручка " + totalRevenue);
        }
    }
}
