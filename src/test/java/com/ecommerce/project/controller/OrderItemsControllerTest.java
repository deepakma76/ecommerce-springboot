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

import com.ecommerce.project.model.OrderItems;
import com.ecommerce.project.repository.OrderItemsRepository;
import com.ecommerce.project.service.OrderItemsService;

@ExtendWith(MockitoExtension.class)
class OrderItemsControllerTest {

	@Mock
	private OrderItemsRepository orderItemsRepository;

	@InjectMocks
	private OrderItemsService orderItemsService;

	@Test
	void testGetAllOrderItems() {
		// Given
		OrderItems orderitems = this.buildOrders();
		// When
		when(orderItemsRepository.findAll()).thenReturn(List.of(orderitems));
		// Then
		List<OrderItems> allOrderItems = orderItemsService.getAllOrderItem();
		Assertions.assertEquals(1, allOrderItems.size());
		verify(this.orderItemsRepository).findAll();
	}

	@Test
	void testGetOrderItemsById() {
		// Given
		OrderItems orderitems = this.buildOrders();
		// When
		when(orderItemsRepository.findById(52L)).thenReturn(Optional.of(orderitems));
		// Then
		Optional<OrderItems> orderItemsById = orderItemsService.getOrderItemById(52L);
		Assertions.assertEquals(orderItemsById.get().getOrderitemid(), 52L);
		verify(this.orderItemsRepository).findById(52L);
	}

	@Test
	void testCreateOrder() {
		// Given
		OrderItems orderitems = this.buildOrders();
		// When
		this.orderItemsService.createOrderItem(orderitems);
		// Then
		verify(this.orderItemsRepository).save(orderitems);
	}

	@Test
	void testUpdateOrder() {
		// Given
		OrderItems orderitems = this.buildOrders();
		// When
		this.orderItemsService.updateOrder(orderitems);
		// Then
		verify(this.orderItemsRepository).save(orderitems);
	}

	@Test
	void testDeleteOrder() {
		// When
		this.orderItemsService.deleteOrderItem(52L);
		// Then
		verify(this.orderItemsRepository).deleteById(52L);
	}

	private OrderItems buildOrders() {
		OrderItems orderitems = new OrderItems();
		orderitems.setOrderid(123L);
		orderitems.setOrderitemid(52L);
		orderitems.setProduct("Cookies");
		return orderitems;
	}

}
