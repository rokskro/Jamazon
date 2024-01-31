package com.testing.model.pojos;

import com.testing.dto.AddToCartDto;
import com.testing.dto.CartDto;

import javax.persistence.*;
@Entity
//@Table(name="cart")
public class Cart {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;

    /*@Column(name = "customerId")
    private Long customerId;

    @Column(name = "productId")
    private Long productId;*/

    private int quantity;

   /* @ManyToOne
    @JoinColumn(name = "customer_id")*/
    private Customer customer;

    /*@ManyToOne
    @JoinColumn(name = "product_id")*/
    private Product product;


    public Cart() {
        super();
    }


    public Cart(Customer customer, Product product, int quantity) {
        this.customer = customer;
        this.product = product;
        this.quantity = quantity;
    }


    public Long getCartId () {
            return cartId;
        }

    public void setCartId (Long cartId){
            this.cartId = cartId;
        }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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