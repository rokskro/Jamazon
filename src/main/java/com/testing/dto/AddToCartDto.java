package com.testing.dto;

import com.sun.istack.NotNull;
import com.testing.model.pojos.Cart;

//add/update products into the cart
public class AddToCartDto {
    private Long customerId;
    private Long productId;
    private Integer quantity;

    public AddToCartDto() {
    }

    public AddToCartDto(Long customerId,Long productId, Integer quantity) {
        this.customerId = customerId;
        this.productId = productId;
        this.quantity = quantity;
    }

    /*public AddToCartDto(Cart cart) {
        this.setCartId(cart.getCartId());
        this.setProductId(cart.getProductId());
        this.setCustomerId(cart.getCustomerId());
        this.setQuantity(cart.getQuantity());
    }*/



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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}