package com.ecommerce.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.project.model.OrderItems;
import com.ecommerce.project.service.OrderItemsService;

@RestController
@RequestMapping(path = "/api")
public class OrderItemsController {

	@Autowired
	OrderItemsService orderItemsService;

	@GetMapping(path = "/order-items")
	public List<OrderItems> getAllOrderItems() {
		return orderItemsService.getAllOrderItem();
	}

	@GetMapping(path = "/order-items/{id}")
	public ResponseEntity<OrderItems> getOrderItemById(@PathVariable Long id) {

		OrderItems orderItem = orderItemsService.getOrderItemById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Order item id " + id + " not found!"));
		return ResponseEntity.ok().body(orderItem);
	}

	@PostMapping(path = "/order-items")
	public ResponseEntity<String> createOrderItem(@RequestBody OrderItems orderitems) {
		try {
			orderItemsService.createOrderItem(orderitems);
			return ResponseEntity.status(HttpStatus.CREATED)
					.body("OrderItem " + orderitems.getOrderitemid() + " created successfully!");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("Exception occurred while creating order " + e.getLocalizedMessage());
		}
	}

	@PutMapping(path = "/order-items/{id}")
	public ResponseEntity<String> updateOrder(@RequestBody OrderItems orderItem, @PathVariable Long id) {
		OrderItems fetchedOrderItem = orderItemsService.getOrderItemById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Order id " + id + " not found!"));

		fetchedOrderItem.setOrderid(orderItem.getOrderid());
		fetchedOrderItem.setProduct(orderItem.getProduct());
		orderItemsService.updateOrder(fetchedOrderItem);
		return ResponseEntity.status(HttpStatus.OK).body("Order item id " + id + " updated successfully!");

	}

	@DeleteMapping(path = "/order-items/{id}")
	public ResponseEntity<String> deleteOrder(@PathVariable Long id) {
		OrderItems deleteId = orderItemsService.getOrderItemById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Order id " + id + " not found!"));

		orderItemsService.deleteOrderItem(deleteId.getOrderitemid());
		return ResponseEntity.status(HttpStatus.OK).body("Order item id " + id + " deleted successfully!");
	}

}
