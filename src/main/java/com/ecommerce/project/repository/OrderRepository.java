package com.ecommerce.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.project.model.Orders;

public interface OrderRepository extends JpaRepository<Orders, Long> {

}
