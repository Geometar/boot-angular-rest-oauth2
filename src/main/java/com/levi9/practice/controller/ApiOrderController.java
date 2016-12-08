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
	public ResponseEntity<Order> saves(@RequestBody List<Component> components, Principal principal) {

		Long orderId = components.get(0).getId() * 2 + components.get(0).getId();
		User user = userService.findByEmail(principal.getName());
		Order order = populateAndSaveOrder(components, user, orderId);
			Boolean isValidate = validateQuantityAndSave(order);
			Boolean isValidateV2 = validationService.isValidate(order);
			if (isValidate == false) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			if (isValidateV2 == false) {
				return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
			}
			
			Order returnOrder = orderService.save(order);

		return new ResponseEntity<>(returnOrder, HttpStatus.CREATED);
	}

	private Boolean validateQuantityAndSave(Order order) {
		for (Component componentL : order.getComponent()) {
			Component component = componentService.findOne(componentL.getId());
			if (component.getQuantity() < componentL.getQuantity()) {
				return false;
			}
			int newQunatity = component.getQuantity() - componentL.getQuantity();
			component.setQuantity(newQunatity);
			componentService.save(component);
		}
		return true;
	}

	private Order populateAndSaveOrder(List<Component> components, User user, Long orderId) {

		Order order = new Order();
		List<Component> componentsSaved = excudeZerosFromComponents(components);
		order.setComponent(componentsSaved);
		order.setTotalAmmount(components);
		order.setUser(user);
		order.setOrderId(orderId);
		return order;
	}
	
	private List<Component> excudeZerosFromComponents(List<Component> components){
		List<Component> componentsList = new ArrayList<>();
		for(Component component: components){
			if(component.getQuantity()!=0){
				componentsList.add(component);
			}
		}
		return componentsList;
	}

}
