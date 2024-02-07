package com.testing.controllers;

import com.testing.dto.RegisterCustomerDto;
import com.testing.model.pojos.Customer;
import com.testing.repo.CustomerRepository;
import com.testing.service.RegisterCustomerService;

import java.rmi.AccessException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class RegisterCustomerController {

    @Autowired
    private RegisterCustomerService registerCustomerService;
    private CustomerRepository customerRepository;

    @PostMapping("/test")
    public String registerCustomer(@RequestBody RegisterCustomerDto registerCustomerDto) {    	
        return registerCustomerService.registerCustomer(registerCustomerDto);

    }
    
    @GetMapping("/get")
    public String testGet() {    	
    	return "Hello Test";
    }
    
    @GetMapping("/getAllCustomers")
    public ResponseEntity<Object> getAllCustomers() {
        try {
            List<Customer> customerList = new ArrayList<>();
            customerRepository.findAll().forEach(customerList::add);
 
            if (customerList.isEmpty()) {
                throw new Exception("There are currently no customers available");
            }
            return new ResponseEntity<>(customerList, HttpStatus.OK);
        }
        catch (AccessException e) {
        	return new ResponseEntity<>(e.getMessage(), HttpStatus.NO_CONTENT);
        }
        catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
