package com.testing.dto;

import com.sun.istack.NotNull;
import com.testing.model.pojos.Cart;

//add/update products into the cart
public class AddToCartDto {
    private Long cartId;
    private @NotNull Long customerId;
    private @NotNull Long productId;
    private @NotNull Integer quantity;

    public AddToCartDto() {
    }

    public AddToCartDto(Long cartId, @NotNull Long customerId, @NotNull Long productId, @NotNull Integer quantity) {
        this.cartId = cartId;
        this.customerId = customerId;
        this.productId = productId;
        this.quantity = quantity;
    }

    public AddToCartDto(Cart cart) {
        this.setCartId(cart.getCartId());
        this.setProductId(cart.getProductId());
        this.setCustomerId(cart.getCustomerId());
        this.setQuantity(cart.getQuantity());
    }

    @Override
    public String toString() {
        return "CartDto{" +
                "id=" + cartId +
                ", customerId =" + customerId +
                ", productId=" + productId +
                ", quantity=" + quantity +
                ",";
    }

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
