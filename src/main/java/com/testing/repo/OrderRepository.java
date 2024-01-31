package com.testing.repo;
import com.testing.model.pojos.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository <Order, Long>{

}
