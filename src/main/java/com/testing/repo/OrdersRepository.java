package com.testing.repo;

import com.testing.model.pojos.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository <Orders, Long>{

}
