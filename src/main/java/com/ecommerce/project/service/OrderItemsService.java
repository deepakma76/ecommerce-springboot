package com.ecommerce.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.project.model.OrderItems;
import com.ecommerce.project.repository.OrderItemsRepository;

@Service
public class OrderItemsService {

	@Autowired
	private OrderItemsRepository orderItemsRepository;

	public List<OrderItems> getAllOrderItem() {
		return orderItemsRepository.findAll();
	}

	public Optional<OrderItems> getOrderItemById(Long id) {
		return orderItemsRepository.findById(id);
	}

	public void createOrderItem(OrderItems orderItem) {
		orderItemsRepository.save(orderItem);
	}

	public void updateOrder(OrderItems orderItem) {
		orderItemsRepository.save(orderItem);
	}

	public void deleteOrderItem(Long id) {
		orderItemsRepository.deleteById(id);
	}
}
