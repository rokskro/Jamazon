package com.testing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.testing.model.pojos.Admin;
import com.testing.repo.AdminRepository;
import com.testing.securityGetDetails.AdminDetails;
 
public class AdminDetailsService implements UserDetailsService {
 
    @Autowired
    private AdminRepository adminRepo;
     
    @Override
    public UserDetails loadUserByUsername(String adminCode) throws UsernameNotFoundException {
       Admin customer = adminRepo.findByAdminCode(adminCode);
        if (customer == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new AdminDetails(customer);
    }
 
}
