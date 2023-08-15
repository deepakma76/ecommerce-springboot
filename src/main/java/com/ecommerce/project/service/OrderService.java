package com.ecommerce.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.ecommerce.project.model.Orders;
import com.ecommerce.project.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Cacheable(cacheNames = "order")
	public List<Orders> getAllOrders() {
		return orderRepository.findAll();
	}

	@Cacheable(cacheNames = "order", key = "#id")
	public Optional<Orders> getOrderById(Long id) {
		return orderRepository.findById(id);
	}

	public void createOrder(Orders order) {
		orderRepository.save(order);
	}

	@CachePut(cacheNames = "order", key = "#order")
	public void updateOrder(Orders order) {
		orderRepository.save(order);
	}

	@CacheEvict(cacheNames = "order", key = "#id")
	public void deleteOrder(Long id) {
		orderRepository.deleteById(id);
	}
}
