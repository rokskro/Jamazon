/**package com.testing.service;

import com.testing.model.enums.OrdersStatus;
import com.testing.model.pojos.*;
import com.testing.repo.*;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class AdminService {

    //@Autowired
   // private ProductRepository productRepo;

    @Autowired
    private OrdersRepository ordersRepo;

    @Autowired
    private CustomerRepository customerRepo;

    //Product methods
    /*public Product addProduct(Product product){
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

    public Customer editCustomer(Customer customer){
        Customer editedCustomer = customerRepo.findById(customer.getCustomerId())
                .orElseThrow(() -> new IllegalArgumentException("Customer not found"));

        editedCustomer.setFirstName(customer.getFirstName());
        editedCustomer.setLastName(customer.getLastName());
        editedCustomer.setEmail(customer.getEmail());
        editedCustomer.setPassword(customer.getPassword());
        editedCustomer.setDateOfBirth(customer.getDateOfBirth());
        editedCustomer.setStarSign(customer.getStarSign());


        return customerRepo.save(editedCustomer);
    }

    //order methods
    public List<Orders> ViewAllOrders() {
        return ordersRepo.findAll();
    }

    public long OrdersCount() {
        return ordersRepo.count();
    }

    public void CancelOrders(Long ordersId) {
        Optional<Orders> orders = ordersRepo.findById(ordersId);
        if(orders.isPresent()) {
            ordersRepo.deleteById(ordersId);
            System.out.println("Order " + ordersId + "has been cancelled successfully");
        }
    }

    public List<Orders> ordersStatusSort() {
        Sort sort = Sort.by(Sort.Direction.ASC, "orderStatus");
        return ordersRepo.findAll(sort);
    }

    public Map<OrdersStatus, Long> countOrdersByStatus() {
        List<Orders> orders = ordersStatusSort();
        return orders.stream()
                .collect(Collectors.groupingBy(Orders::getOrdersStatus, Collectors.counting()));
    }



}*/
