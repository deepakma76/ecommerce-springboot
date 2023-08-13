package com.ecommerce.project.controller;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ecommerce.project.model.Orders;
import com.ecommerce.project.repository.OrderRepository;
import com.ecommerce.project.service.OrderService;

@ExtendWith(MockitoExtension.class)
class OrderControllerTest {

	@Mock
	private OrderRepository orderRepository;

	@InjectMocks
	private OrderService orderService;

	@Test
	void testGetAllOrders() {
		// Given
		Orders orders = this.buildOrders();
		// When
		when(orderRepository.findAll()).thenReturn(List.of(orders));
		// Then
		List<Orders> allOrders = orderService.getAllOrders();
		Assertions.assertEquals(1, allOrders.size());
		verify(this.orderRepository).findAll();
	}

	@Test
	void testGetOrderById() {
		// Given
		Orders orders = this.buildOrders();
		// When
		when(orderRepository.findById(123L)).thenReturn(Optional.of(orders));
		// Then
		Optional<Orders> orderById = orderService.getOrderById(123L);
		Assertions.assertEquals(orderById.get().getOrderid(), 123L);
		verify(this.orderRepository).findById(123L);
	}

	@Test
	void testCreateOrder() {
		// Given
		Orders orders = this.buildOrders();
		// When
		this.orderService.createOrder(orders);
		// Then
		verify(this.orderRepository).save(orders);
	}

	@Test
	void testUpdateOrder() {
		// Given
		Orders orders = this.buildOrders();
		// When
		this.orderService.updateOrder(orders);
		// Then
		verify(this.orderRepository).save(orders);
	}

	@Test
	void testDeleteOrder() {
		// When
		this.orderService.deleteOrder(123L);
		// Then
		verify(this.orderRepository).deleteById(123L);
	}

	private Orders buildOrders() {
		Orders orders = new Orders();
		orders.setOrderid(123L);
		orders.setName("Deepak");
		orders.setAddress("Mumbai");
		orders.setPhone("8097230767");
		return orders;
	}

}
