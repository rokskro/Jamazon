package com.testing.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.testing.dto.RegisterCustomerDto;
import com.testing.model.pojos.Customer;
import com.testing.repo.CustomerRepository;
import jdk.internal.org.jline.terminal.TerminalBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class RegisterCustomerService {

    @Autowired
    private CustomerRepository customerRepo;

    public String registerCustomer(RegisterCustomerDto registerCustomerDto){
        Customer customer = new ObjectMapper().convertValue(registerCustomerDto, Customer.class);
        
        //Encoding password so that in database it is hash value is stored, improved security
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(customer.getPassword());
        customer.setPassword(encodedPassword);
        
        Long customerId = customerRepo.save(customer).getCustomerId();

        return "Customer registered successfully: " + customerId;
    }


}
