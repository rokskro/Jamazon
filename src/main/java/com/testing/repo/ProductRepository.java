package com.testing.repo;

import com.testing.model.enums.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import com.testing.model.pojos.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository <Product, Long> {
    //Product addProductToCart(Product product);
    List<Product> findProductName(String query);
    List<Product> findProductCategory(ProductCategory category);
}
