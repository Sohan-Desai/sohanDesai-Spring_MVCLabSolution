package com.greatlearning.order.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.order.model.Order;
import com.greatlearning.order.service.OrderService;

@RestController
@RequestMapping("/api/vi/orders")
public class OrderRestController {

	private OrderService orderService;

	@Autowired
	public OrderRestController(OrderService orderService) {
		this.orderService = orderService;
	}

	@GetMapping
	public Set<Order> fetchAllOrders() {
		return this.orderService.fetchAllOders();
	}

	@GetMapping("/{id}")
	public Order fetchOrderById(@PathVariable("id") long orderId) {
		return this.orderService.findOrderById(orderId);
	}

	@PutMapping("/{id}")
	public Order updateOrderById(@PathVariable("id") long orderId, @RequestBody Order updatedOrder) {
		
		return this.orderService.updateOrder(orderId, updatedOrder);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Order saveOrder(@RequestBody Order order) {
		return this.orderService.saveOrder(order);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteByOrderId(@PathVariable("id") long orderId) {
		this.orderService.deleteOrderById(orderId);
	}

}
