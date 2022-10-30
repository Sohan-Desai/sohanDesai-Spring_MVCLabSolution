package com.greatlearning.order.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.order.model.Order;
import com.greatlearning.order.repository.OrderRepository;

@Service
public class OrderService {

	/*
	 * in memory set of orders private Set<Order> orders = new HashSet<>();
	 */

	@Autowired
	private OrderRepository orderRepository;

	public OrderService(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	// save an order
	public Order saveOrder(Order order) {
		return this.orderRepository.save(order);
	}

	// fetch all orders
	public Set<Order> fetchAllOders() {
		return new HashSet<>(this.orderRepository.findAll());
	}

	// find an order based on id
	public Order findOrderById(long orderId) {
		return this.orderRepository.findAll().stream().filter(order -> order.getId() == orderId).findAny()
				.orElseThrow(() -> new IllegalArgumentException("Illegal order id is passed"));
	}

	// delete an order based on id
	public void deleteOrderById(long orderId) {
		this.orderRepository.deleteById(orderId);
	}

	public Order updateOrder(long orderId, Order updatedOrder) {
		Order savedOrder = this.findOrderById(orderId);
		savedOrder.setCustomerName(updatedOrder.getCustomerName());
		savedOrder.setPrice(updatedOrder.getPrice());
		savedOrder.setOrderDate(updatedOrder.getOrderDate());
		savedOrder.setEmail(updatedOrder.getEmail());

		this.orderRepository.save(savedOrder);
		return savedOrder;
	}
}
