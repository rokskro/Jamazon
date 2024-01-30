package com.testing.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.testing.model.pojos.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
