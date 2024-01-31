package com.testing.service;

import com.testing.model.pojos.*;
import com.testing.repo.CustomerRepository;
import com.testing.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepo;

    @Autowired
    private ProductRepository productRepo;



    public Customer addCustomer( Customer customer) {
        return customerRepo.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return customerRepo.findAll();
    }

    public void deleteCustomer (long customerId) {
        customerRepo.deleteById(customerId);
    }

    public Customer updateCustomer(Long customerId, Customer updatedCustomer) {
        return customerRepo.findById(customerId)
                .map(customer -> {
                    customer.setFirstName(updatedCustomer.getFirstName());
                    customer.setLastName(updatedCustomer.getLastName());
                    customer.setEmail(updatedCustomer.getEmail());
                    customer.setDateOfBirth(updatedCustomer.getDateOfBirth());
                    customer.setPassword(updatedCustomer.getPassword());
                    customer.setStarSign(updatedCustomer.getStarSign());
                    return customerRepo.save(customer);
                })
                .orElseGet(() -> {
                    updatedCustomer.setCustomerId(customerId);
                    return customerRepo.save(updatedCustomer);
                });

    }

    /*public Product addProductToCart(Customer customer, Product product) {
        return productRepo.addProductToCart(product);
    }
     */

    //Product methods
    public List<Product> ViewAll() {
        return productRepo.findAll();
    }

    public List<Product> Search(String query) {
        return productRepo.findProductName(query);
    }

    public List<Product> SearchDesc(String query) {
        List<Product> products = productRepo.findProductName(query);
        products.sort(Comparator.comparing(Product::getDescription));
        return products;
    }

    public List<Product> FilterByType(String typeQuery) {
        return productRepo.findProductCategory(typeQuery);
    }

    public List<Product> FilterByTypeDesc(String typeQuery) {
        List<Product> products = productRepo.findProductCategory(typeQuery);
        products.sort(Comparator.comparing(Product::getDescription).reversed());
        return products;
    }






}
