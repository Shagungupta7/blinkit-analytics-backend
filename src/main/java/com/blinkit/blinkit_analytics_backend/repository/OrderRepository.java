package com.blinkit.blinkit_analytics_backend.repository;
import com.blinkit.blinkit_analytics_backend.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
public interface OrderRepository extends JpaRepository<Order, Long>{
}
