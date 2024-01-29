package com.testing.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.testing.dto.RegisterCustomerDto;
import com.testing.model.Customer;
import com.testing.repo.CustomerRepository;
import jdk.internal.org.jline.terminal.TerminalBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class RegisterCustomerService {

    @Autowired
    private CustomerRepository customerRepo;

    public String registerCustomer(RegisterCustomerDto registerCustomerDto){
        Customer customer = new ObjectMapper().convertValue(registerCustomerDto, Customer.class);
        Long customerId = customerRepo.save(customer).getCustomerId();

        return "Customer registered successfully: " + customerId;
    }


}
