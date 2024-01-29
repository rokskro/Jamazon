package com.testing.model;

import java.util.HashMap;

public class Order {
    Long orderId;
    HashMap<Product, Integer> productList = new HashMap<Product, Integer>();
    Long address;
    double totalCost;
    String datePlaced;
    OrderStatus orderStatus;

    public Order(){

    }

    public Order(Long orderId, HashMap<Product, Integer> productList, Long address, double totalCost, String datePlaced, OrderStatus orderStatus) {
        this.orderId = orderId;
        this.productList = productList;
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

    public HashMap<Product, Integer> getProductList() {
        return productList;
    }

    public void setProductList(HashMap<Product, Integer> productList) {
        this.productList = productList;
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

}
