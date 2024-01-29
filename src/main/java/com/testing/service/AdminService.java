package com.testing.service;
import com.testing.model.Product;
import com.testing.repo.*;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class AdminService {

    @Autowired
    private ProductRepository productRepo;

    @Autowired
    private OrderRepository orderRepo;

    //Product methods

    public Product addProduct(Product product){
        return product.save(product);
    }
    public void deleteProduct(){}





}
