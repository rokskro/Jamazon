package com.testing.service;
import com.testing.model.*;
import com.testing.repo.*;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class AdminService {

    @Autowired
    private ProductRepository productRepo;

    @Autowired
    private OrderRepository orderRepo;

    @Autowired
    private CustomerRepository customerRepo;

    //Product methods

    public Product addProduct(Product product){
        return productRepo.save(product);
    }

    public void deleteProduct(Long productId){
        productRepo.deleteById(productId);
    }

    public Product editProduct(Product product){
        Product editedProduct = productRepo.findById(product.getProductId())
                .orElseThrow(() -> new IllegalArgumentException("Product not found"));

        editedProduct.setProductName(product.getProductName());
        editedProduct.setValue(product.getValue());
        editedProduct.setDescription(product.getDescription());
        editedProduct.setImage(product.getImage());
        editedProduct.setQuantity(product.getQuantity());
        editedProduct.setProductCategory(product.getProductCategory());

        return productRepo.save(editedProduct);
    }

    //Customer methods

    public void deleteCustomer(Long customerId){
        customerRepo.deleteById(customerId);
    }






}
