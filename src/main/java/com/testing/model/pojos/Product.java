package com.testing.model.pojos;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.testing.model.enums.ProductCategory;

@Entity
public class Product {
    @Id
    Long productId;
    String productName;
    double value;
    String description;
    String image;
    int quantity;

    ProductCategory productCategory;


    public Product() {
        super();
        //TODO Auto-Generated Constructor stub
    }

    public Product(Long productId, String productName, double value, String description, String image, int quantity, ProductCategory productCategory) {
        super();
        this.productId = productId;
        this.productName = productName;
        this.value = value;
        this.description = description;
        this.image = image;
        this.quantity = quantity;
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
}
