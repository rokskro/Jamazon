package com.testing.controllers;

import com.testing.dto.RegisterCustomerDto;
import com.testing.service.RegisterCustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class RegisterCustomerController {

    @Autowired
    private RegisterCustomerService registerCustomerService;

    @PostMapping("/addCustomer")
    public String registerCustomer(@RequestBody RegisterCustomerDto registerCustomerDto) {    	
        return registerCustomerService.registerCustomer(registerCustomerDto);

    }    
}
