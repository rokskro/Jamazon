package com.testing.repo;
import com.testing.model.Order;
import com.testing.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository <Order, Long>{
}
