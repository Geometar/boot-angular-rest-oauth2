package com.levi9.practice.service.impl;

import org.springframework.stereotype.Service;

import com.levi9.practice.model.Order;
import com.levi9.practice.model.Component;
import com.levi9.practice.model.ComponentValue;
import com.levi9.practice.service.QuantityValidationService;

@Service
public class ValidationServiceImpl implements QuantityValidationService {

	@Override
	public boolean isValidate(Order order) {

		for (Component c : order.getComponent()) {

			switch (c.getValue().toString()) {

			case "OPTIONAL_ONE":
				if (c.getQuantity() > 1) {
					return false;
				}
				return true;
			case "REQUIRED_ONE":
				if (c.getQuantity() != 1) {
					return false;
				}
				return true;
			case "OPTIONAL_N":
				return true;

			case "REQUIRED_N":
				if (c.getQuantity() < 1)
					return false;
				return true;
			default:
				return true;
			}
		}
		return true;
	}
}
