package com.testing.securityGetDetails;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.testing.model.pojos.Admin;
 
public class AdminDetails implements UserDetails {
 
    private Admin admin;
     
    public AdminDetails(Admin admin) {
        this.admin = admin;
    }
 
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }
 
    @Override
    public String getPassword() {
        return admin.getPassword();
    }
 
    @Override
    public String getUsername() {
        return admin.getEmail();
    }
 
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
 
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
 
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
 
    @Override
    public boolean isEnabled() {
        return true;
    }
     
    public String getFullName() {
        return admin.getFirstName() + " " + admin.getLastName();
    }
 
}