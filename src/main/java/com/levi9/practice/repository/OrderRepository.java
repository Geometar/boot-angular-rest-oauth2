package com.levi9.practice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.levi9.practice.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
	
	Order findByOrderId(Long orderId);
	Order findByUser_Firstname(String firstName);
	List<Order> findByUser_Id(Long id);
}
