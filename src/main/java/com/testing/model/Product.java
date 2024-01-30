package com.testing.model;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productId;
    private String productName;
    private double value;
    private String description;
    private String image;
    private int quantity;
    @OneToMany(mappedBy="product", cascade = CascadeType.ALL)
    private List<OrderProduct> orderProducts = new ArrayList<>();
    private ProductCategory productCategory;

    public Product() {
        super();
        //TODO Auto-Generated Constructor stub
    }

    public Product(Long productId, String productName, double value, String description, String image, int quantity, List<OrderProduct> orderProducts, ProductCategory productCategory) {
        this.productId = productId;
        this.productName = productName;
        this.value = value;
        this.description = description;
        this.image = image;
        this.quantity = quantity;
        this.orderProducts = orderProducts;
        this.productCategory = productCategory;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public List<OrderProduct> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(List<OrderProduct> orderProducts) {
        this.orderProducts = orderProducts;
    }}