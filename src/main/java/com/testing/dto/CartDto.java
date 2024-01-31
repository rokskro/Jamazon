package com.testing.dto;



import com.sun.istack.NotNull;
import com.testing.model.enums.OrderStatus;
import com.testing.model.pojos.Cart;
import com.testing.model.pojos.Customer;
import com.testing.model.pojos.Product;

import java.util.HashMap;

public class CartDto {
    private long cartId;
    private @NotNull long customerId;
    private @NotNull int quantity;
    private @NotNull Product product;

    public CartDto() {
        super();
    }

    public CartDto(Cart cart) {
        this.setCartId(cart.getCartId());
        this.setCustomerId(cart.getCustomerId());
        this.setQuantity(cart.getQuantity());
        this.setProduct(cart.getProduct());
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


}