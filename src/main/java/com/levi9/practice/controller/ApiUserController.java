package com.levi9.practice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.levi9.practice.model.Configurator;
import com.levi9.practice.model.Order;
import com.levi9.practice.model.User;
import com.levi9.practice.service.OrderService;
import com.levi9.practice.service.UserService;

@RestController
@RequestMapping("api/user")
public class ApiUserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping(method = RequestMethod.GET, value="/{id}")
	public ResponseEntity<User> findOne(@PathVariable Long id){
		System.out.println("User id: " + id);
		User user = userService.findOne(id);
		
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/{id}/configuration")
	public ResponseEntity<List<Order>> findOrders(@PathVariable Long id){
		
		List<Order> orders = orderService.findByUser_Id(id);
		if(orders == null){
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(orders ,HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/{id}", consumes="application/json")
	public ResponseEntity<User> save(@PathVariable Long id ,@RequestBody User user){
		
		if(user.getId()!= null && user.getId() != id){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		User savedUser = userService.save(user);
		return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
	}
}
