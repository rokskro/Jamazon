
package com.testing.dto;

import com.sun.istack.NotNull;
import com.testing.model.pojos.Cart;
import com.testing.model.pojos.Customer;
import com.testing.model.pojos.Product;

import java.util.HashMap;

public class CartDto {
    private Long cartId;
    private Long customerId;
    private Long productId;
    private int quantity;

    public CartDto() {
        super();
    }

    // Constructor using cart entity
    public CartDto(Cart cart) {
        this.cartId = cart.getCartId();
        this.customerId = cart.getCustomer().getCustomerId();
        this.productId = cart.getProduct().getProductId();
        this.quantity = cart.getQuantity();
    }

    public long getCartId() {
        return cartId;
    }

    public void setCartId(long cartId) {
        this.cartId = cartId;
    }

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
