package com.ecommerce.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.project.model.OrderItems;

public interface OrderItemsRepository extends JpaRepository<OrderItems, Long> {

}
