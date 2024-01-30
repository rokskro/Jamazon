package com.testing.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testing.model.pojos.Product;

public interface ProductRepository extends JpaRepository <Product, Long> {
    Product addProductToCart(Product product);
}
