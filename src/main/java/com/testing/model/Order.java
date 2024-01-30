package com.testing.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="order")
public class Order {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "orderId")
    private Long orderId;

@ManyToMany
private List<OrderProduct> orderedProducts = new ArrayList<>();

    private Long address;
    private double totalCost;
    private String datePlaced;
    private OrderStatus orderStatus;

    public Order() {
    }

    public Order(Long orderId, List<OrderProduct> orderedProducts, Long address, double totalCost, String datePlaced, OrderStatus orderStatus) {
        this.orderId = orderId;
        this.orderedProducts = orderedProducts;
        this.address = address;
        this.totalCost = totalCost;
        this.datePlaced = datePlaced;
        this.orderStatus = orderStatus;
    }

    public Long getOrderId() {
        return orderId;
    }
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getAddress() {
        return address;
    }

    public void setAddress(Long address) {
        this.address = address;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public String getDatePlaced() {
        return datePlaced;
    }

    public void setDatePlaced(String datePlaced) {
        this.datePlaced = datePlaced;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public List<OrderProduct> getOrderProducts() {
        return orderedProducts;
    }

    public void setOrderProducts(List<OrderProduct> orderedProducts) {
        this.orderedProducts = orderedProducts;
    }

}
