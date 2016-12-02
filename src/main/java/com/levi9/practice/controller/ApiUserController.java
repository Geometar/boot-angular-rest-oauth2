package com.levi9.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
	
}
