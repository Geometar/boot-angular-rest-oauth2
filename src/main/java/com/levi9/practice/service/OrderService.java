package com.levi9.practice.service;

import java.util.List;

import com.levi9.practice.model.Order;

public interface OrderService {
	
	List<Order> findAll();
	Order findOne(Long id);
	Order save(Order order);
	List<Order> save(List<Order> orders);
	Order delete(Long id);
	Order findByUser_Username(String username);

}
