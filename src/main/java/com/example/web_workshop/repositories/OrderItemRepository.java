package com.example.web_workshop.repositories;

import com.example.web_workshop.entities.Order;
import com.example.web_workshop.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {
}
