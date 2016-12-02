package com.levi9.practice.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.levi9.practice.model.Component;
import com.levi9.practice.model.ComponentValue;
import com.levi9.practice.model.Order;
import com.levi9.practice.model.User;
import com.levi9.practice.service.ComponentService;
import com.levi9.practice.service.OrderService;
import com.levi9.practice.service.QuantityValidationService;
import com.levi9.practice.service.UserService;

@RestController
@RequestMapping("api/order")
public class ApiOrderController {

	@Autowired
	OrderService orderService;

	@Autowired
	ComponentService componentService;
	
	@Autowired
	UserService userService;

	@Autowired
	QuantityValidationService validationService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Order>> findAll() {
		List<Order> findAll = orderService.findAll();
		return new ResponseEntity<>(findAll, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<List<Order>> saves(@RequestBody List<Component> components, Principal principal) {

		List<Order> order2 = new ArrayList<>();
		Long orderId = components.get(0).getId() * 2 + components.get(0).getId();

		for (Component c : components) {
			User user = userService.findByEmail(principal.getName());
			Component component = componentService.findOne(c.getId());
			Order order = populateAndSaveOrder(c, user, orderId);
			Boolean isValidate = validateQuantityAndSave(component, order);
			Boolean isValidateV2 = validationService.isValidate(order);
			if (isValidate == false) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			if(isValidateV2 == false){
				return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
			}
			order2.add(order);
		}
		order2 = orderService.save(order2);
		return new ResponseEntity<>(order2, HttpStatus.CREATED);
	}

	private Boolean validateQuantityAndSave(Component c, Order order) {
		System.out.println(c.getQuantity());
		System.out.println(order.getQuantity());
		if (c.getQuantity() < order.getQuantity()) {
			return false;
		}
		int newQunatity = c.getQuantity() - order.getQuantity();
		c.setQuantity(newQunatity);
		componentService.save(c);
		return true;
	}

	private Order populateAndSaveOrder(Component c, User user, Long orderId) {

		Order order = new Order();
		order.setComponent(c);
		order.setPrice(c.getPrice());
		order.setQuantity(c.getQuantity());
		order.setValue(c.getValue());
		order.setUser(user);
		order.setOrderId(orderId);
		return order;
	}

}
