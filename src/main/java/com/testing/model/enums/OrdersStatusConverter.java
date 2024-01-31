package com.testing.model.enums;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.*;

@Converter(autoApply = true)
public class OrdersStatusConverter implements AttributeConverter<OrdersStatus, String> {
 
    @Override
    public String convertToDatabaseColumn(OrdersStatus ordersStatus) {
        if (ordersStatus == null) {
            return null;
        }
        return ordersStatus.getOrdersStatus();
    }

    @Override
    public OrdersStatus convertToEntityAttribute(String status) {
        if (status == null) {
            return null;
        }

        return Stream.of(OrdersStatus.values())
          .filter(c -> c.getOrdersStatus().equals(status))
          .findFirst()
          .orElseThrow(IllegalArgumentException::new);
    }
}
