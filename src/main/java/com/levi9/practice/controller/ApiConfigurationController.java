package com.levi9.practice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.levi9.practice.model.Configurator;
import com.levi9.practice.service.ConfigurationService;

@RestController
@RequestMapping(value = "api/configuration")
public class ApiConfigurationController {

	@Autowired
	private ConfigurationService configurationService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Configurator>> getConfigurations() {
		List<Configurator> configurations = configurationService.findAll();
		return new ResponseEntity<>(configurations, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<Configurator> save(@RequestBody Configurator configurator) {

		Configurator configuratorSaved = configurationService.save(configurator);
		return new ResponseEntity<Configurator>(configuratorSaved, HttpStatus.CREATED);
	}
}
