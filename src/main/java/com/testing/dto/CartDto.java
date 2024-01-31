package com.testing.dto;


import com.testing.model.enums.OrderStatus;
import com.testing.model.pojos.Customer;
import com.testing.model.pojos.Product;

import java.util.HashMap;

public class CartDto {

    public CartDto() {
        super();
    }

    public CartDto(Long customerId, Long productId, int quantity) {
        super();
        this.customerId = customerId;
        this.productId = productId;
        this.quantity = quantity;
    }

    private Long customerId;
    private Long productId;
    private int quantity;



    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


}
