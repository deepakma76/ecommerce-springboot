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

import com.ecommerce.project.model.Orders;
import com.ecommerce.project.service.OrderService;

@RestController
@RequestMapping(path = "/api")
public class OrderController {

	@Autowired
	OrderService orderService;

	@GetMapping(path = "/orders")
	public ResponseEntity<List<Orders>> getAllOrders() {
		return ResponseEntity.ok(orderService.getAllOrders());
	}

	@GetMapping(path = "/orders/{id}")
	public ResponseEntity<Orders> getOrderById(@PathVariable Long id) {
		Orders order = orderService.getOrderById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Order id " + id + " not found!"));
		return ResponseEntity.ok().body(order);
	}

	@PostMapping(path = "/orders")
	public ResponseEntity<String> createOrder(@RequestBody Orders order) {
		try {
			if (order.getPhone().length() == 10) {
				orderService.createOrder(order);
				return ResponseEntity.status(HttpStatus.CREATED)
						.body("Order " + order.getOrderid() + " created successfully!");
			} else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Phone should be of 10 digit!");
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("Exception occurred while creating order " + e.getLocalizedMessage());
		}
	}

	@PutMapping(path = "/orders/{id}")
	public ResponseEntity<String> updateOrder(@RequestBody Orders order, @PathVariable Long id) {
		Orders fetchedOrder = orderService.getOrderById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Order id " + id + " not found!"));

		fetchedOrder.setName(order.getName());
		fetchedOrder.setPhone(order.getPhone());
		fetchedOrder.setAddress(order.getAddress());
		orderService.updateOrder(fetchedOrder);
		return ResponseEntity.status(HttpStatus.OK).body("Order id " + id + " updated successfully!");

	}

	@DeleteMapping(path = "/orders/{id}")
	public ResponseEntity<String> deleteOrder(@PathVariable Long id) {
		Orders deleteId = orderService.getOrderById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Order id " + id + " not found!"));
		orderService.deleteOrder(deleteId.getOrderid());
		return ResponseEntity.status(HttpStatus.OK).body("Order id " + id + " deleted successfully!");

	}
}
