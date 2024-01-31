package com.testing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.testing.model.pojos.Customer;
import com.testing.repo.CustomerRepository;
import com.testing.securityGetDetails.CustomerDetails;
 
public class CustomerDetailsService implements UserDetailsService {
 
    @Autowired
    private CustomerRepository customerRepo;
     
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Customer customer = customerRepo.findByEmail(username);
        if (customer == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new CustomerDetails(customer);
    }
 
}

