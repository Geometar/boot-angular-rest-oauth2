package com.levi9.practice.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.levi9.practice.model.Component;
import com.levi9.practice.model.UnexistingComponentException;
import com.levi9.practice.repository.ComponentRepository;
import com.levi9.practice.service.ComponentService;

@Service
@Transactional
public class JpaComponentService implements ComponentService {
	
@Autowired
private ComponentRepository componentReposiroty;
	
@Override
public Component findOne(Long id) {
		return componentReposiroty.findOne(id);
	}

@Override
public Component save(Component component){
		
	return componentReposiroty.save(component);	
	}
	
@Override
public Component delete(Long id) throws UnexistingComponentException{
		Component component = componentReposiroty.findOne(id);
		if(component==null){
			throw new UnexistingComponentException(
					"Component not found with ID " + id);
		}
		componentReposiroty.delete(component);
		return component;
	}

@Override
public Page<Component> findAll(Integer page) {
	return componentReposiroty.findAll(new PageRequest(page, 4));
	}

@Override
public Page<Component> findByType(Integer page, String type) {
		return componentReposiroty.findByTypeLike(new PageRequest(page, 4) ,"%" + type);
	}
}


