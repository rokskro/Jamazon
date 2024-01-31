package com.testing.service;

import com.testing.model.pojos.Customer;
import com.testing.model.pojos.Product;
import com.testing.repo.CustomerRepository;
import com.testing.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

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

 //   public List<Customer> getAllCustomers() {
//        return customerRepo.findAll();
//    }

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






}
