package com.example.parsing;

import com.example.model.Order;
import com.example.parsing.exception.IncorrectFileFormatException;

import java.time.LocalDateTime;

public class OrderParserImpl  implements OrderParser {
    public Order parse(String line) {
        String[] pieces = line.split("[\\|]");
        if (pieces.length < 3)  {

           throw
               new IncorrectFileFormatException("Неккоректный формат строки " + line);

        }
        LocalDateTime dateTime = LocalDateTime.parse(pieces[0]);
        double orderAmount = Double.parseDouble(pieces[2]);
        return new Order(pieces[1], orderAmount, dateTime);
    }
}
