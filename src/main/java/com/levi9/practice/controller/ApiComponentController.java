package com.levi9.practice.controller;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.levi9.practice.model.Component;
import com.levi9.practice.model.UnexistingComponentException;
import com.levi9.practice.model.User;
import com.levi9.practice.service.ComponentService;
import com.levi9.practice.service.UserService;

@RestController
@RequestMapping(value = "api/component")
public class ApiComponentController {

	@Autowired
	private ComponentService componentService;
	
	@Autowired
	private UserService userService;
	

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Component>> getComponents(
			@RequestParam(value = "pageNumber", required=false) Integer pageNumber,
			@RequestParam(value = "filter_query", required = false) String filter,
			Principal principal) {

		Page<Component> components = null;
		
		Integer page = pageValidatation(pageNumber);

		if (filter != null) {
			components = componentService.findByType(page, filter);
		} else {
			components = componentService.findAll(page);
		}
		User user = userService.findByEmail(principal.getName());
		HttpHeaders headers = new HttpHeaders();
		headers.add("ukupno-elemnata", components.getTotalElements()+"");
		headers.add("username", user.getFirstname()+"");
		headers.add("id", user.getId()+"");

		return new ResponseEntity<>(components.getContent(),headers, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = "application/json")
	public ResponseEntity<Component> editComponent(@PathVariable Long id, @RequestBody @Valid Component component) {

		if (component == null || component.getId() != id) {
			return new ResponseEntity<Component>(HttpStatus.BAD_REQUEST);
		}

		Component componenta = componentService.findOne(id);
		componenta.setName(component.getName());
		componenta.setItemCode(component.getItemCode());
		componenta.setPrice(component.getPrice());
		componenta.setQuantity(component.getQuantity());
		componenta.setType(component.getType());
		componenta.setValue(component.getValue());

		Component componentEdited = componentService.save(componenta);
		return new ResponseEntity<Component>(componentEdited, HttpStatus.OK);

	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<Component> deleteComponent(@PathVariable Long id) throws UnexistingComponentException {

		System.out.println(id);
		Component component = componentService.findOne(id);
		System.out.println(component.getQuantity());
		if (component.getQuantity() == 0) {
			componentService.delete(id);
			return new ResponseEntity<Component>(component, HttpStatus.OK);
		}
		return new ResponseEntity<Component>(HttpStatus.FORBIDDEN);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Component> getComponent(@PathVariable Long id) {
		Component component = componentService.findOne(id);
		if (component == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(component, HttpStatus.OK);
	}

	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<Component> save(@RequestBody Component component) {
		
		if(component.getId()!=null){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
			Component ret = componentService.save(component);
			return new ResponseEntity<>(ret, HttpStatus.CREATED);
	}
	
	private Integer pageValidatation(Integer page){
		if (page == null){
			page = 0;
		}
		return page;
	}
}
