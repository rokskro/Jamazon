package com.testing.model.pojos;

import com.testing.dto.CartDto;

import javax.persistence.*;
@Entity
@Table(name="cart")
public class Cart {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;

    @Column(name = "customerId")
    private Long customerId;

    @Column(name = "productId")
    private Long productId;

    private int quantity;

    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;


    public Cart() {
        super();
    }


    public Cart(CartDto cartDto, Product product, Customer customer, long customerId) {
        this.customerId = customerId;
        this.productId = cartDto.getProductId();
        this.quantity = cartDto.getQuantity();
        this.product = product;
    }


        public Long getCartId () {
            return cartId;
        }

        public void setCartId (Long cartId){
            this.cartId = cartId;
        }

        public int getQuantity () {
            return quantity;
        }

        public void setQuantity (int quantity){
            this.quantity = quantity;
        }

        public Long getCustomerId () {
            return customerId;
        }

        public void setCustomerId (Long customerId){
            this.customerId = customerId;
        }

        public Long getProductId () {
            return productId;
        }

        public void setProductId (Long productId){
            this.productId = productId;
        }


}