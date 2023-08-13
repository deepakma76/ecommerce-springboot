package com.ecommerce.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.project.model.Orders;
import com.ecommerce.project.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	public List<Orders> getAllOrders() {
		return orderRepository.findAll();
	}

	public Optional<Orders> getOrderById(Long id) {
		return orderRepository.findById(id);
	}

	public void createOrder(Orders order) {
		orderRepository.save(order);
	}

	public void updateOrder(Orders order) {
		orderRepository.save(order);
	}

	public void deleteOrder(Long id) {
		orderRepository.deleteById(id);
	}
}
