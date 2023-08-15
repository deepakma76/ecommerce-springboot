package com.ecommerce.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.ecommerce.project.model.OrderItems;
import com.ecommerce.project.repository.OrderItemsRepository;

@Service
public class OrderItemsService {

	@Autowired
	private OrderItemsRepository orderItemsRepository;

	@Cacheable(cacheNames = "orderitem")
	public List<OrderItems> getAllOrderItem() {
		return orderItemsRepository.findAll();
	}

	@Cacheable(cacheNames = "orderitem", key = "#id")
	public Optional<OrderItems> getOrderItemById(Long id) {
		return orderItemsRepository.findById(id);
	}

	public void createOrderItem(OrderItems orderItem) {
		orderItemsRepository.save(orderItem);
	}

	@CachePut(cacheNames = "orderitem", key = "#orderItem")
	public void updateOrder(OrderItems orderItem) {
		orderItemsRepository.save(orderItem);
	}

	@CacheEvict(cacheNames = "orderitem", key = "#id")
	public void deleteOrderItem(Long id) {
		orderItemsRepository.deleteById(id);
	}
}
