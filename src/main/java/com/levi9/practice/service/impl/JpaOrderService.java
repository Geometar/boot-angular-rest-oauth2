package com.levi9.practice.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.levi9.practice.model.Order;
import com.levi9.practice.repository.OrderRepository;
import com.levi9.practice.service.OrderService;

@Service
@Transactional
public class JpaOrderService implements OrderService {
	
	@Autowired
	OrderRepository orderRepository;

	@Override
	public List<Order> findAll() {
		return orderRepository.findAll();
	}

	@Override
	public Order findOne(Long id) {
		// TODO Auto-generated method stub
		return orderRepository.findOne(id);
	}

	@Override
	public Order save(Order order) {
		// TODO Auto-generated method stub
		return orderRepository.save(order);
	}

	@Override
	public Order delete(Long id) {
		
		return null;
	}

	@Override
	public Order findByUser_Username(String username) {
		// TODO Auto-generated method stub
		return null;
//		return orderRepository.findByUser_Firstname(username);
	}

	@Override
	public List<Order> save(List<Order> orders) {
		
		return orderRepository.save(orders);
	}

}
