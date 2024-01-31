package com.testing.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.testing.model.pojos.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
	@Query("SELECT c FROM Customer c WHERE c.email = ?1")
    public Admin findByAdminCode(String adminCode);
}