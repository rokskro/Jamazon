package com.testing.model.enums;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.*;

@Converter(autoApply = true)
public class OrderStatusConverter implements AttributeConverter<OrderStatus, String> {
 
    @Override
    public String convertToDatabaseColumn(OrderStatus orderStatus) {
        if (orderStatus == null) {
            return null;
        }
        return orderStatus.getOrderStatus();
    }

    @Override
    public OrderStatus convertToEntityAttribute(String status) {
        if (status == null) {
            return null;
        }

        return Stream.of(OrderStatus.values())
          .filter(c -> c.getOrderStatus().equals(status))
          .findFirst()
          .orElseThrow(IllegalArgumentException::new);
    }
}
