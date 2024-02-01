package com.testing.model.pojos;

import com.testing.model.enums.OrdersStatus;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="orders")
public class Orders {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "ordersId")
    private Long ordersId;

@OneToMany
private List<OrderProduct> orderedProducts = new ArrayList<>();

    private Long address;
    private double totalCost;
    private String datePlaced;
    private OrdersStatus ordersStatus;

    public Orders() {
    }

    public Orders(Long ordersId, List<OrderProduct> orderedProducts, Long address, double totalCost, String datePlaced, OrdersStatus ordersStatus) {
        this.ordersId = ordersId;
        this.orderedProducts = orderedProducts;
        this.address = address;
        this.totalCost = totalCost;
        this.datePlaced = datePlaced;
        this.ordersStatus = ordersStatus;
    }

    public Long getOrdersId() {
        return ordersId;
    }
    public void setOrdersId(Long ordersId) {
        this.ordersId = ordersId;
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

    public OrdersStatus getOrdersStatus() {
        return ordersStatus;
    }

    public void setOrdersStatus(OrdersStatus ordersStatus) {
        this.ordersStatus = ordersStatus;
    }

    public List<OrderProduct> getOrderProducts() {
        return orderedProducts;
    }

    public void setOrderProducts(List<OrderProduct> orderedProducts) {
        this.orderedProducts = orderedProducts;
    }

}
